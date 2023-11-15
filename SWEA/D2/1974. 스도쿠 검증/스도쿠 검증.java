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
			int isCheck = 1;
			
			int [][] nums = new int[10][10];

			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					nums[i][j] = sc.nextInt();
				}
			}

			ArrayList<Integer> [][] part = new ArrayList [3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					part[i][j] = new ArrayList<>(); 
				}
			}
			
			for (int i = 1; i <= 9; i++) {
				ArrayList<Integer> width = new ArrayList<>();
				ArrayList<Integer> height = new ArrayList<>();
				for (int j = 1; j <= 9; j++) {
					part[(i-1)/3][(j-1)/3].add(nums[i][j]);
					width.add(nums[i][j]);
					height.add(nums[j][i]);
				}
				
				// 가로 세로 확인
				if(width.stream().distinct().count() != 9 ||
						height.stream().distinct().count() != 9) {
					isCheck = 0;
					break;
				}
			}
			
			// 3 x 3  부분 확인
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(part[i][j].stream().distinct().count() != 9) {
						isCheck = 0;
						break;
					}
				}
			}
			
			System.out.println("#" + test_case  + " " + isCheck);
			
		}
	}
}