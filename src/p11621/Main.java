package p11621;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static int modifiedBinarySearch(List<Integer> numbers, Integer n) {
		int low = 0;
		int high = numbers.size() - 1;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;

			if (numbers.get(mid).compareTo(n) < 0)
				low = mid + 1;
			else if (numbers.get(mid).compareTo(n) > 0)
				high = mid - 1;
			else
				return numbers.get(mid);
		}
		
		return mid < numbers.size() && numbers.get(mid) < n ? numbers.get(mid+1) : numbers.get(mid); 			//Premissa: O(T(n)) = log(n)
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();														//1
		for(int i=0; i<32; i++) {																				//n
			for(int j=0; j<32; j++) {																			//n*n => n^2
				BigDecimal val = BigDecimal.valueOf(Math.pow(2, i) * Math.pow(3, j));							//n*n => n^2
				if(val.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) < 0)									//n*n => n^2
					numbers.add(val.toBigInteger().intValue());													//n*n => n^2
			}
		}
		numbers.sort(null);																						//Premissa: O(T(n)) = n * log(n)

		Scanner input = new Scanner(System.in);																	//1

		int n = input.nextInt();																				//1
		
		while(n != 0) {																							//n
			System.out.println(modifiedBinarySearch(numbers,n));												//n*log(n)
			n = input.nextInt();																				//n
		}
		
																												//T(n) = 4n^2 + 2n*log(n) + 3n + 3
																												//O(T(n)) = n^2
	}
}
