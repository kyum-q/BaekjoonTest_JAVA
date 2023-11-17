import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            int [] dx = {0, +1, 0, -1};
            int [] dy = {1 , 0, -1, 0};

            int[][] nums = new int[N+2][N+2];

            int x = 1;
            int y = 1;
            int move = 0;

            for (int i = 0; i < N+2; i++) {
                nums[0][i] = -1;
                nums[i][0] = -1;
                nums[N+1][i] = -1;
                nums[i][N+1] = -1;
            }

            for (int i = 1; i <= N*N; i++) {
                nums[x][y] = i;

                if (nums[x+dx[move]][y+dy[move]] != 0) {
                    move = (move + 1) % 4;
                }

                x += dx[move];
                y += dy[move];
            }

            System.out.println("#"+ test_case);
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(nums[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
