import java.util.*;
import java.util.stream.Stream;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		//System.setIn(new FileInputStream("res/input.txt"));


		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int emptyWidth[][] = new int [N+1][N+1];
			int emptyHeight[][] = new int [N+1][N+1];
			
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int num = sc.nextInt();
					if(num == 1) {
						emptyWidth[i][j] = emptyWidth[i][j-1] + 1;
						emptyHeight[i][j] = emptyHeight[i-1][j] + 1; 
					}
					else {
						if(emptyWidth[i][j-1] == K) {
							sum++;
						}
						if(emptyHeight[i-1][j] == K) {
							sum++;
						}
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(emptyWidth[i][N] == K) {
					sum++;
				}
				if(emptyHeight[N][i] == K) {
					sum++;
				}
			}
			
			System.out.println("#" + test_case + " " + sum);
			
		}
	}
}