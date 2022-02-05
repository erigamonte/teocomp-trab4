package p447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static char[][] createMap(){
		char[][] map = new char[20][20];														//1
		for(int i=0; i<20; i++) {																//n
			for(int j=0; j<20; j++) {															//n*n => n^2
				map[i][j] = ' ';																//n*n => n^2
			}
		}
		return map;																				//1
		
																								//T(n)= 2n^2+ n + 2
																								//O(T(n))= n^2
	}
	
	public static int getQtNeighboors(char[][] map, int i, int j) {
		int count = 0;																			//1
	    for (int c = j-1 ; c <= j+1 ; c++) {													//n
	        for (int l = i-1 ; l <= i+1 ; l++) {												//n*n => n^2
	            if(c != j || l != i) {															//n*n => n^2
	                if(checkEdges(l, c) && map[l][c] == 'O') {									//n*n => n^2
	                	count++;																//n*n => n^2
	                }
	            }
	        }
	    }
	    return count;																			//1
	    
	    																						//T(n)= 4n^2 + n + 2
	    																						//O(T(n)) = n^2
	}
	
	public static boolean checkEdges(int i, int j) {
	    if(j<0 || i<0) {																		//1
	        return false;
	    }
	    if(j>=20 || i>=20) {																	//1
	        return false;
	    }
	    return true;																			//1
	    		
	    																						//T(n) = 3
	    																						//O(T(n)) = 1
	}
	
	public static char[][] processMap(char[][] map){
		char[][] newMap = createMap();															//n^2
		for(int i=0; i<20; i++) {																//n
			for(int j=0; j<20; j++) {															//n*n => n^2
				int qtNeig = getQtNeighboors(map, i, j);										//n*n * n^2 => n^4
				if((qtNeig == 2 || qtNeig == 3) && map[i][j] == 'O')							//n*n => n^2
					newMap[i][j] = 'O';
				else if(qtNeig >= 4 || qtNeig <= 1)												//n*n => n^2
					newMap[i][j] = ' ';
				else if(qtNeig == 3 && map[i][j] == ' ')										//n*n => n^2
					newMap[i][j] = 'O';															//n*n => n^2
			}
		}
		return newMap; 																			//1
		
																								//T(n) = n^4 + 6n^2 + n + 1
																								//O(T(n)) = n^4
	}
	
	public static void printMap(char[][] map) {
		System.out.println("********************");												//1
		for(int i=0; i<20; i++) {																//n
			for(int j=0; j<20; j++) {															//n*n => n^2
				System.out.print(map[i][j]);													//n*n => n^2
			}
			System.out.print("\n");																//n
			
																								//T(n)= 2n^2 + 2n + 1
																								//O(T(n))= n^2
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		int n = Integer.parseInt(br.readLine());

		br.readLine();
		
		for (int i=0; i<n; i++) {
			
			int years = Integer.parseInt(br.readLine());										//1
			
			char[][] map = createMap();															//1											
			
			while (true) {																		//n
				s=br.readLine();																//n
				if (s==null || s.length()==0) break;											//n
				String[] numbs = s.split(" ");													//n-1
				map[Integer.parseInt(numbs[0])-1][Integer.parseInt(numbs[1])-1] = 'O';			//n-1
			}
			
			printMap(map);																		//n^2
			
			for(int j=1; j<years; j++) {														//n
				map = processMap(map);															//n* n^4 => n^5
				printMap(map);																	//n* n^2 => n^3
			}
			System.out.println("********************");											//1
			if(i<n-1) System.out.println();														//2
			
																								
																								//T(n)= n^5 + n^3 + 4n + 2(n-1) + 5 => n^5 + n^3 + 6n + 3
																								//O(T(n))= n^5
		}
	}
}
 