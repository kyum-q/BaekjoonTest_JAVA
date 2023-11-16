
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
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < N; i++) {
                String c = sc.next();
                int count = sc.nextInt();
                for (int j = 0; j < count; j++) {
                    s.append(c);
                }
            }

            System.out.printf("#%d\n", test_case);

            int i;
            for (i=0 ;i + 10 < s.length(); i += 10) {
                System.out.println(s.substring(i, i + 10));
            }
            if (i < s.length()) {
                System.out.println(s.substring(i, s.length()));
            }
        }
    }
}