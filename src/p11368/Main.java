package p11368;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	class Doll {
		int w;
		int h;

		public Doll(int w, int h) {
			this.w = w;
			this.h = h;
		}
		
		public boolean lowerThen(Doll d) {
			return this.w < d.w && this.h < d.h;
		}

		@Override
		public String toString() {
			return "Doll [w=" + w + ", h=" + h + "]";
		}
	}
	
	public static int modifiedBinarySearch(List<Doll> dolls, Doll d) {
		int low = 0;
		int high = dolls.size() - 1;
		int mid = 0;

		while (low < high) {
			mid = (low + high) / 2;

			if (dolls.get(mid).w <= d.w)
				low = mid + 1;
			else
				high = mid;
		}
		
		return low;																//Premissa: O(T(n)) = log(n)
	}

	public static void main(String[] args) {
		Main m = new Main();
		Scanner input = new Scanner(System.in);

		int t = input.nextInt();

		for (int i = 0; i<t ; i++) {
			int n = input.nextInt();											//1
			
			List<Doll> dolls = new ArrayList<Doll>();							//1
			
			for (int j = 0; j < n; j++) {										//n
				dolls.add(m.new Doll(input.nextInt(), input.nextInt()));		//n
			}
			
			Collections.sort(dolls, new Comparator<Doll>() {					//Premissa: O(T(n)) = n*log(n)
			    public int compare(Doll d1, Doll d2) {		    	
			    	if(d1.h==d2.h) return d1.w - d2.w;
		            return d2.h - d1.h;
			    }
			});
			
			ArrayList<Doll> nestedDolls = new ArrayList<Doll>();				//1
			nestedDolls.add(dolls.get(0));										//1
			
			for(int j=1; j<dolls.size(); j++) {									//n
				int pos = modifiedBinarySearch(nestedDolls, dolls.get(j));		//n * log(n)
				if(dolls.get(j).lowerThen(nestedDolls.get(pos))) {				//n
					nestedDolls.remove(pos);									//n
					nestedDolls.add(pos, dolls.get(j));							//n
				}
				else {
					nestedDolls.add(dolls.get(j));
				}
			}
			
			System.out.println(nestedDolls.size());								
																				//T(n) = 2n * log(n) + 6n + 4
																				//O(T(n)) = n * log(n)
		}
	}
}
