package p12247;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static int[] readLine(Scanner input) {
		int[] line = new int[5];
		int i=0;
		while(i<5) {
			line[i] = input.nextInt();
			i++;
		}
		return line;
	}
	
	public static boolean mustEnd(int[] line) {
		return line[0] == 0;
	}
	
	public static int greaterThenHowMany(int[] abc, int card) {
		int count=0;																								//1
		for(int i=0; i<abc.length; i++) {																			//n
			if(abc[i] < card)																						//n
				count++;																							//n
		}
		return count;																								//1
		
																													//T(n)= 3n + 2
																													//O(T(n))= n
	}
	
	public static int findNewCardByMiddle(int[] deck) {
		int princessMiddleCard;																						//1													
		
		if((deck[0] > deck[1] && deck[0] < deck[2]) || (deck[0] < deck[1] && deck[0] > deck[2]))					//1
			princessMiddleCard = deck[0];
		else if((deck[1] > deck[2] && deck[1] < deck[0]) || (deck[1] < deck[2] && deck[1] > deck[0]))				//1
			princessMiddleCard = deck[1];
		else 
			princessMiddleCard = deck[2];																			//1
		
		return findMinimumCard(deck, princessMiddleCard);															//n^2
		
		
																													//T(n)= n^2 + 4
																													//O(T(n))= n^2
																				
	}
	
	public static int findNewCardByHight(int[] deck) {
		int princessHightCard;																						//1
		
		if(deck[0] > deck[1] && deck[0] > deck[2])																	//1
			princessHightCard = deck[0];
		else if(deck[1] > deck[2] && deck[1] > deck[0])																//1
			princessHightCard = deck[1];
		else 
			princessHightCard = deck[2];																			//1
		
		return findMinimumCard(deck, princessHightCard);															//n^2
		
																				
																													//T(n)= n^2 + 4
																													//O(T(n))= n^2
	}
	
	public static int findMinimumCard(int[] deck, int cardBase) {
		for(int i=cardBase+1; i<=52; i++) {																			//n
			boolean contains = false;																				//n
			for(int j=0; j<deck.length; j++) {																		//n*n => n^2
				if(deck[j] == i)																					//n*n => n^2
					contains = true;																				//n*n => n^2
			}
			if(!contains)																							//n
				return i;																							//n	
		}
		return -1;																			
		
		
																													//T(n)= 3n^2 + 4n
																													//O(T(n))= n^2
	}
	
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		int[] line = readLine(input);

		while (!mustEnd(line)) {
			int[] abc = new int[] {line[0], line[1], line[2]};														//1
			int x = line[3];																						//1
			int y = line[4];																						//1
			
			int xGreaterThen = greaterThenHowMany(abc, x);															//n
			int yGreaterThen = greaterThenHowMany(abc, y);															//n
			
			if((xGreaterThen == 0 && yGreaterThen == 0) ||
					(xGreaterThen <= 2 && yGreaterThen == 0) ||
					(xGreaterThen == 0 && yGreaterThen <= 2) ||
					(xGreaterThen == 1 && yGreaterThen <= 2) ||
					(xGreaterThen <= 2 && yGreaterThen <= 1))														//1
				System.out.println(-1);
			else if(xGreaterThen == 3 && yGreaterThen == 3) {														//1
				System.out.println(findMinimumCard(line, 0));
			}
			else if((xGreaterThen == 3 && yGreaterThen <= 1) ||
					(xGreaterThen <= 1 && yGreaterThen == 3)) {														//1
				System.out.println(findNewCardByHight(line));
			}
			else {
				System.out.println(findNewCardByMiddle(line));														//n^2
			}

			line = readLine(input);																					
			
						
																													//T(n)= n^2 + 2n + 6
																													//O(T(n))= n^2
		}
	}

}