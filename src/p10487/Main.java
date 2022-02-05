package p10487;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

class Main {

	public static Integer[] doSums(Integer[] numbers) {
		HashSet hash = new HashSet<Integer>(); 																					//1
		for (int k = 0; k < numbers.length; k++) {																				//n
			for (int q = k + 1; q < numbers.length; q++) {																		//n * n => n^2
				int sum = numbers[k] + numbers[q];																				//n * (n-1) => n^2 - n
				hash.add(sum);																									//n * (n-1) => n^2 - n
			}
		}

		return (Integer[]) hash.stream().sorted().toArray(Integer[]::new);  													//n*log(n) 
																																//T(n) = 3n^2 - n + 1
																																//O(T(n)) = n^2
	}

	public static int modifiedBinarySearch(Integer[] numbers, Integer n) {
		int low = 0;
		int high = numbers.length - 1;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;

			if (numbers[mid].compareTo(n) < 0)
				low = mid + 1;
			else if (numbers[mid].compareTo(n) > 0)
				high = mid - 1;
			else
				return numbers[mid];
		}
		
		int diffUp = mid+1 < numbers.length ? Math.abs(numbers[mid + 1] - n) : Integer.MAX_VALUE;
		int diffMiddle = Math.abs(numbers[mid] - n);
		int diffBottom = mid > 0 ? Math.abs(numbers[mid - 1] - n) : Integer.MAX_VALUE;
		
		if(diffUp < diffMiddle && diffUp < diffBottom)
			return numbers[mid + 1];
		else if(diffBottom < diffMiddle)
			return numbers[mid - 1];
		return numbers[mid];																									//Premissa: O(T(n)) = log(n)
	}

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt(); 							
														
		for (int qt = 0; n != 0; qt++) {					
			Integer[] numbers = new Integer[n];																					//1

			for (int j = 0; j < n; j++) {																						//n
				numbers[j] = input.nextInt();																					//n
			}

			Integer[] sumsOrdered = doSums(numbers);        																	//n^2

			int m = input.nextInt();																							//1

			System.out.print("Case " + (qt + 1) + ":\n");																		//1
			for (int q = 0; q < m; q++) {																						//n
				int query = input.nextInt();																					//n
				System.out.print("Closest sum to " + query + " is " + (modifiedBinarySearch(sumsOrdered, query)) + ".\n"); 		//n * log(n) 
			}																													
																																//T(n) = n^2 + n * log(n) + 4n + 3
																																//O(T(n)) = n^2


			n = input.nextInt(); 																								
		}
	}
}