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
			
			System.out.println("#" + test_case);
			
			int [] price = {50000,10000,5000,1000,500,100,50,10};
			int [] result = new int [8];
			
			for(int i=0;i<8;i++) {
				result[i] = N/price[i];
				N %= price[i]; 
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
	}
}