import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int num = test_case;
            boolean is369 = false;

            for (int i = 1; i < num; i *= 10) {
                int newNum = num /i % (i*10);
                if(newNum != 0 && newNum % 3 == 0) {
                    System.out.print("-");
                    is369 = true;
                }
            }
            if(!is369)
                System.out.print(num);

            System.out.print(" ");
        }
    }
}