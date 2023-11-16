
import java.util.Scanner;

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

            int [] nums = {2,3,5,7,11};
            int [] result = new int[5];

            while(N != 1) {
                for (int i = 0; i < 5; i++) {
                    if(N % nums[i] == 0) {
                        result[i]++;
                        N = N/nums[i];
                    }
                }
            }

            System.out.printf("#%d ", test_case);
            for (int i = 0; i < 5; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}