import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            int[][] nums = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }

            System.out.println("#"+test_case);
            for (int i = 0; i < N; i++) {
                for (int k = 1; k <= N; k++) {
                    System.out.print(nums[N-k][i]);
                }
                System.out.print(" ");
                for (int k = 1; k <= N; k++) {
                    System.out.print(nums[N-i-1][N-k]);
                }
                System.out.print(" ");
                for (int k = N; k >= 1; k--) {
                    System.out.print(nums[N-k][N-i-1]);
                }


                System.out.println();
            }
        }
    }
}