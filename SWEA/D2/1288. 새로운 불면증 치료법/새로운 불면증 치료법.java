
import java.util.ArrayList;
import java.util.List;
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

            int result = 1;
            ArrayList<Integer> nums = new ArrayList<>();
            while(nums.stream().distinct().count() != 10) {
                int n = N*result;
                while(n > 0) {
                    nums.add(n%10);
                    n = n/10;
                }
                result++;
            }


            System.out.printf("#%d %d\n", test_case, (result-1) * N);
        }
    }
}