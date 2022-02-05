package p167;

import java.util.Scanner;

class Main {
	
	//solucoes fixas das posicoes das rainhas
	public static int[][] solutionsQueenProblem() {
		return new int [][] {
			 new int []{1, 5, 8, 6, 3, 7, 2, 4},
			 new int []{1, 6, 8, 3, 7, 4, 2, 5},
			 new int []{1, 7, 4, 6, 8, 2, 5, 3},
			 new int []{1, 7, 5, 8, 2, 4, 6, 3},
			 new int []{2, 4, 6, 8, 3, 1, 7, 5},
			 new int []{2, 5, 7, 1, 3, 8, 6, 4},
			 new int []{2, 5, 7, 4, 1, 8, 6, 3},
			 new int []{2, 6, 1, 7, 4, 8, 3, 5},
			 new int []{2, 6, 8, 3, 1, 4, 7, 5},
			 new int []{2, 7, 3, 6, 8, 5, 1, 4},
			 new int []{2, 7, 5, 8, 1, 4, 6, 3},
			 new int []{2, 8, 6, 1, 3, 5, 7, 4},
			 new int []{3, 1, 7, 5, 8, 2, 4, 6},
			 new int []{3, 5, 2, 8, 1, 7, 4, 6},
			 new int []{3, 5, 2, 8, 6, 4, 7, 1},
			 new int []{3, 5, 7, 1, 4, 2, 8, 6},
			 new int []{3, 5, 8, 4, 1, 7, 2, 6},
			 new int []{3, 6, 2, 5, 8, 1, 7, 4},
			 new int []{3, 6, 2, 7, 1, 4, 8, 5},
			 new int []{3, 6, 2, 7, 5, 1, 8, 4},
			 new int []{3, 6, 4, 1, 8, 5, 7, 2},
			 new int []{3, 6, 4, 2, 8, 5, 7, 1},
			 new int []{3, 6, 8, 1, 4, 7, 5, 2},
			 new int []{3, 6, 8, 1, 5, 7, 2, 4},
			 new int []{3, 6, 8, 2, 4, 1, 7, 5},
			 new int []{3, 7, 2, 8, 5, 1, 4, 6},
			 new int []{3, 7, 2, 8, 6, 4, 1, 5},
			 new int []{3, 8, 4, 7, 1, 6, 2, 5},
			 new int []{4, 1, 5, 8, 2, 7, 3, 6},
			 new int []{4, 1, 5, 8, 6, 3, 7, 2},
			 new int []{4, 2, 5, 8, 6, 1, 3, 7},
			 new int []{4, 2, 7, 3, 6, 8, 1, 5},
			 new int []{4, 2, 7, 3, 6, 8, 5, 1},
			 new int []{4, 2, 7, 5, 1, 8, 6, 3},
			 new int []{4, 2, 8, 5, 7, 1, 3, 6},
			 new int []{4, 2, 8, 6, 1, 3, 5, 7},
			 new int []{4, 6, 1, 5, 2, 8, 3, 7},
			 new int []{4, 6, 8, 2, 7, 1, 3, 5},
			 new int []{4, 6, 8, 3, 1, 7, 5, 2},
			 new int []{4, 7, 1, 8, 5, 2, 6, 3},
			 new int []{4, 7, 3, 8, 2, 5, 1, 6},
			 new int []{4, 7, 5, 2, 6, 1, 3, 8},
			 new int []{4, 7, 5, 3, 1, 6, 8, 2},
			 new int []{4, 8, 1, 3, 6, 2, 7, 5},
			 new int []{4, 8, 1, 5, 7, 2, 6, 3},
			 new int []{4, 8, 5, 3, 1, 7, 2, 6},
			 new int []{5, 1, 4, 6, 8, 2, 7, 3},
			 new int []{5, 1, 8, 4, 2, 7, 3, 6},
			 new int []{5, 1, 8, 6, 3, 7, 2, 4},
			 new int []{5, 2, 4, 6, 8, 3, 1, 7},
			 new int []{5, 2, 4, 7, 3, 8, 6, 1},
			 new int []{5, 2, 6, 1, 7, 4, 8, 3},
			 new int []{5, 2, 8, 1, 4, 7, 3, 6},
			 new int []{5, 3, 1, 6, 8, 2, 4, 7},
			 new int []{5, 3, 1, 7, 2, 8, 6, 4},
			 new int []{5, 3, 8, 4, 7, 1, 6, 2},
			 new int []{5, 7, 1, 3, 8, 6, 4, 2},
			 new int []{5, 7, 1, 4, 2, 8, 6, 3},
			 new int []{5, 7, 2, 4, 8, 1, 3, 6},
			 new int []{5, 7, 2, 6, 3, 1, 4, 8},
			 new int []{5, 7, 2, 6, 3, 1, 8, 4},
			 new int []{5, 7, 4, 1, 3, 8, 6, 2},
			 new int []{5, 8, 4, 1, 3, 6, 2, 7},
			 new int []{5, 8, 4, 1, 7, 2, 6, 3},
			 new int []{6, 1, 5, 2, 8, 3, 7, 4},
			 new int []{6, 2, 7, 1, 3, 5, 8, 4},
			 new int []{6, 2, 7, 1, 4, 8, 5, 3},
			 new int []{6, 3, 1, 7, 5, 8, 2, 4},
			 new int []{6, 3, 1, 8, 4, 2, 7, 5},
			 new int []{6, 3, 1, 8, 5, 2, 4, 7},
			 new int []{6, 3, 5, 7, 1, 4, 2, 8},
			 new int []{6, 3, 5, 8, 1, 4, 2, 7},
			 new int []{6, 3, 7, 2, 4, 8, 1, 5},
			 new int []{6, 3, 7, 2, 8, 5, 1, 4},
			 new int []{6, 3, 7, 4, 1, 8, 2, 5},
			 new int []{6, 4, 1, 5, 8, 2, 7, 3},
			 new int []{6, 4, 2, 8, 5, 7, 1, 3},
			 new int []{6, 4, 7, 1, 3, 5, 2, 8},
			 new int []{6, 4, 7, 1, 8, 2, 5, 3},
			 new int []{6, 8, 2, 4, 1, 7, 5, 3},
			 new int []{7, 1, 3, 8, 6, 4, 2, 5},
			 new int []{7, 2, 4, 1, 8, 5, 3, 6},
			 new int []{7, 2, 6, 3, 1, 4, 8, 5},
			 new int []{7, 3, 1, 6, 8, 5, 2, 4},
			 new int []{7, 3, 8, 2, 5, 1, 6, 4},
			 new int []{7, 4, 2, 5, 8, 1, 3, 6},
			 new int []{7, 4, 2, 8, 6, 1, 3, 5},
			 new int []{7, 5, 3, 1, 6, 8, 2, 4},
			 new int []{8, 2, 4, 1, 7, 5, 3, 6},
			 new int []{8, 2, 5, 3, 1, 7, 4, 6},
			 new int []{8, 3, 1, 6, 2, 5, 7, 4},
			 new int []{8, 4, 1, 3, 6, 2, 7, 5}};
	}
	
	public static void main(String[] args) {
		int n = 8;														

		int[][] res = solutionsQueenProblem();							
		
		Scanner input = new Scanner(System.in);								

		int k = input.nextInt();										
		
		for(int i=0; i<k; i++) {										
			int[][] board = new int[8][8];								//1
			
			for(int c=0; c<8; c++) {									//n
				for(int l=0; l<8; l++) {								//n*n => n^2
					board[c][l] = input.nextInt();						//n*n => n^2
				}
			}
			
			int max = 0;												//1
			for(int j=0; j<res.length; j++) {							//n
				int sum = 0;											//n
				for(int s=0; s<8; s++) {								//n*n => n^2
					sum += board[res[j][s]-1][s];						//n*n => n^2
				}
				
				if(sum>max)												//n
					max=sum;											//n
			}
			
			System.out.println(String.format("%1$" + 5 + "s", max));	//1
			
			
																		//T(n) = 4n^2 + 6n + 6
																		//O(T(n)) = n^2
		}
	}
}
