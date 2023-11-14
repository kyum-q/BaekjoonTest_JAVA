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

            int sum = 0;

            for (int i = 1; i <= N; i++) {
                if (i % 2 == 0)
                    sum -= i;
                else
                    sum += i;
            }

            System.out.printf("#%d %d\n", test_case, sum);
        }
    }
}