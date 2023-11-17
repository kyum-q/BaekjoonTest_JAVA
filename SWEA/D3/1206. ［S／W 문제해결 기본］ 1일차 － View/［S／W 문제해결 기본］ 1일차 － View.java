import java.util.*;
import java.util.stream.Stream;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = sc.nextInt();
			
			int[] nums = new int [N+1];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt(); 
			}
			
			int result = 0;
			for (int i = 2; i < N-2; i++) {
				int num = nums[i];
				int max = Math.max(Math.max(nums[i-1], nums[i-2]), 
							Math.max(nums[i+1], nums[i+2]));
				if(max < num) {
					result += num-max;
				}	
			}
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}