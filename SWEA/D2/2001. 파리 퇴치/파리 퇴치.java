import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("src/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] nums = new int[N + 1][N + 1];
            int[][] sums = new int[N + 1][N + 1];

            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    nums[i][j] = sc.nextInt();
                    sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + nums[i][j];
                }
            }

            int max = 0;
            for (int i = M; i < N + 1; i++) {
                for (int j = M; j < N + 1; j++) {
                    int newMax = sums[i][j] - sums[i-M][j] - sums[i][j-M] + sums[i-M][j-M];
                    max = Math.max(max, newMax);
                }
            }

            System.out.printf("#%d %d\n", test_case, max);
        }
    }
}