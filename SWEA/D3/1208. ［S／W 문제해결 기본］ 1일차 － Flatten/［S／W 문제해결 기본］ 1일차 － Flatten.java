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
			int [] nums = new int[101];
			for (int i = 0; i < 100; i++) {
				nums[i] = sc.nextInt();
			}
			
			int avg = Arrays.stream(nums).sum()/100;
			
			while(N > 0) {
				Arrays.sort(nums);
				
				nums[0]++;
				nums[100]--;
				N--;
			}
			Arrays.sort(nums);
			
			System.out.println("#"+test_case+" " + (nums[100]-nums[0]-1));
		}
	}
}