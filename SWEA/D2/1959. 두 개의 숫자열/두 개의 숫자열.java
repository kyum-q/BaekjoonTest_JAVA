import java.util.Arrays;
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
            int M = sc.nextInt();

            int A [] =new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            int B [] =new int[M];
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }

            int[] maxValue, minValue;

            if(N >= M) {
                maxValue = A;
                minValue = B;
            } else {
                maxValue = B;
                minValue = A;
            }

            int max = 0;
            for (int i = 0; i <= maxValue.length - minValue.length; i++) {
                int[] value = Arrays.copyOfRange(maxValue, i, i + minValue.length);
                for (int j = 0; j < minValue.length; j++) {
                    value[j] *= minValue[j];
                }
                max = Math.max(max, Arrays.stream(value).sum());
            }
            System.out.printf("#%d %d\n", test_case, max);
        }
    }
}