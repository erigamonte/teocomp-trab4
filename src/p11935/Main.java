package p11935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static final String FUEL_CONSUMPTION_TOKEN = " Fuel consumption ";
	public static final String LEAK_TOKEN = " Leak";
	public static final String GAS_STATION_TOKEN = " Gas station";
	public static final String MECHANIC_TOKEN = " Mechanic";
	public static final String GOAL_TOKEN = " Goal";
	
	public static final int FUEL_CONSUMPTION_TYPE = 1;
	public static final int LEAK_TYPE = 2;
	public static final int GAS_STATION_TYPE = 3;
	public static final int MECHANIC_TYPE = 4;
	public static final int GOAL_TYPE = 5;
	
	class Input {
		int type;
		int km;
		int value;
		
		public Input(int type, int km, int value) {
			this.type = type;
			this.km = km;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Input [type=" + type + ", km=" + km + ", value=" + value + "]";
		}
	}
	
	public static int[] fuelConsuptionParser(String line) {
		String[] fconsuptionString = line.replace(FUEL_CONSUMPTION_TOKEN, " ").split(" ");
		return new int[] {Integer.valueOf(fconsuptionString[0]), Integer.valueOf(fconsuptionString[1])};
	}
	
	public static int leakParser(String line) {
		return Integer.valueOf(line.replace(LEAK_TOKEN, ""));
	}
	
	private static int mechanicParser(String line) {
		return Integer.valueOf(line.replace(MECHANIC_TOKEN, ""));
	}
	
	private static int gasStationParser(String line) {
		return Integer.valueOf(line.replace(GAS_STATION_TOKEN, ""));
	}
	
	private static int goalParser(String line) {
		return Integer.valueOf(line.replace(GOAL_TOKEN, ""));
	}
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		while(!s.equals("0 Fuel consumption 0")) {
			
			List<Input> inputs = new ArrayList<Input>();																		//1
			
			while(!s.contains(GOAL_TOKEN)) {																					//n
				if (s.contains(FUEL_CONSUMPTION_TOKEN))																			
					inputs.add(m.new Input(FUEL_CONSUMPTION_TYPE, fuelConsuptionParser(s)[0], fuelConsuptionParser(s)[1]));		
				else if(s.contains(LEAK_TOKEN))																					//n				
					inputs.add(m.new Input(LEAK_TYPE, leakParser(s), -1));																
				else if(s.contains(MECHANIC_TOKEN))																				//n
					inputs.add(m.new Input(MECHANIC_TYPE, mechanicParser(s), -1));
				else if(s.contains(GAS_STATION_TOKEN))																			//n
					inputs.add(m.new Input(GAS_STATION_TYPE, gasStationParser(s), -1));											//n
				
				s = br.readLine();																								//n
				
			}
			
			inputs.add(m.new Input(GOAL_TYPE, goalParser(s), -1));																//1
			
			int consumption = inputs.get(0).value;																				//1
			int totalLeak = 0;																									//1
			BigDecimal tank = BigDecimal.ZERO;																					//1
			BigDecimal minTank = BigDecimal.ZERO;																				//1
			for(int i=1; i<inputs.size(); i++) {																				//n
				tank = tank.add(BigDecimal.valueOf((inputs.get(i).km - inputs.get(i-1).km) * (consumption/100.0)));				//n
				
				if(totalLeak > 0)																								//n
					tank = tank.add(BigDecimal.valueOf((inputs.get(i).km - inputs.get(i-1).km) * totalLeak));					//n
				
				if (inputs.get(i).type == FUEL_CONSUMPTION_TYPE) {																//n
					consumption = inputs.get(i).value;
				} else if(inputs.get(i).type == LEAK_TYPE) {																	//n
					totalLeak++;		
				} else if(inputs.get(i).type == MECHANIC_TYPE) {																//n
					totalLeak = 0;
				} else if(inputs.get(i).type == GAS_STATION_TYPE) {																//n
					if(tank.compareTo(minTank) > 0) {																			//n
						minTank = tank;																							//n
					}
					tank = BigDecimal.ZERO;																						//n
				}
			}
			
			if(tank.compareTo(minTank) > 0) {																					//1
				minTank = tank;																									//1
			}
			
			minTank = minTank.setScale(3, BigDecimal.ROUND_HALF_EVEN);															//1
			
			System.out.println(minTank);																						//1
			
			s = br.readLine();																									//1
																																
																																//T(n) = 17n + 11
																																//O(T(n)) = n
		}
	}
}
