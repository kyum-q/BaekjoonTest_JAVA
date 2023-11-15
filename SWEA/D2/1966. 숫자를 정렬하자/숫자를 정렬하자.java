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
			
			int [] nums = new int [N];
			for(int i=0;i<N;i++) {
				nums[i] = sc.nextInt(); 
			}
			
			Arrays.sort(nums);
			
			System.out.print("#" + test_case + " ");
			for(int i=0;i<N;i++) {
				System.out.print(nums[i] + " "); 
			}
			System.out.println();
		}
	}
}