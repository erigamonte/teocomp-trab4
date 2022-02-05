package p10602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static int modifiedBinarySearch(List<String> words, String w) {
		int low = 0;
		int high = words.size() - 1;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;

			if (words.get(mid).compareTo(w) < 0)
				low = mid + 1;
			else if (words.get(mid).compareTo(w) > 0)
				high = mid - 1;
			else
				return mid;
		}
		
		int diffUp = mid+1 < words.size() ? numberCharsEquals(w, words.get(mid+1)) : -1;
		int diffMiddle = numberCharsEquals(w, words.get(mid));
		int diffBottom = mid > 0 ? numberCharsEquals(w, words.get(mid-1)) : -1;
		
		if(diffUp >= diffMiddle && diffUp >= diffBottom)
			return mid + 1;
		else if(diffBottom > diffMiddle)
			return mid - 1;
		return mid;																					//Premissa: O(T(n)) = n*log(n)
	}
	
	public static int numberCharsEquals(String one, String two) {
		int lowerLen = one.length() > two.length() ? two.length() : one.length();					//1
		
		int count = 0;																				//1
		for(int i=0; i<lowerLen; i++) {																//n
			if(one.charAt(i) != two.charAt(i))														//n
				break;
			count++;																				//n
		}
		return count;																				//n 
																									
																									//result = 3n + 2 => n
																									//O(T(n)) = n
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i<t; i++) {
			int n = Integer.parseInt(br.readLine()); 												//1
			
			List<String> words = new ArrayList<String>();											//1
			
			for(int j=0; j<n; j++) {																//n
				words.add(br.readLine());															//n
			}
			
			List<String> wordsOrdered = new ArrayList<String>(words); 								//1
			Collections.sort(wordsOrdered);															//n * log(n)
			
			
			List<String> finalOrder = new ArrayList<String>();										//1
			
			int index = wordsOrdered.indexOf(words.get(0));											//n
			wordsOrdered.remove(words.get(0));														//n
			finalOrder.add(words.get(0));															//1		
			
			while(wordsOrdered.size() > 0) {														//n
				index = modifiedBinarySearch(wordsOrdered, finalOrder.get(finalOrder.size()-1));	//n * (n*log(n)) => n^2 * log(n)
				finalOrder.add(wordsOrdered.get(index));											//n * n => n^2
				wordsOrdered.remove(index);															//n * n => n^2
			}
			
			int count = finalOrder.get(0).length();													//1
			for(int j=1; j<finalOrder.size(); j++) {												//n
				int charsEq = numberCharsEquals(finalOrder.get(j-1), finalOrder.get(j));			//n * n => n^2
				count += finalOrder.get(j).length() - charsEq;										//n
			}																						
																									//T(n) = n^2 * log(n) + 3 n^2  + n * log(n) + 6
																									//O(T(n)) = n^2 * log(n)
			System.out.println(count);
			for (String f : finalOrder) {
				System.out.println(f);
			}
		}
	}
}
