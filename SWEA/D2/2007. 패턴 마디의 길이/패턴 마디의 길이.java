import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String s = sc.nextLine();

            int firstStart = 0;
            int secondStart = 0;
            boolean isChecking = false;

            int result = 0;

            for(int i=1;i<s.length();i++) {
                if(!isChecking) {
                    if (s.charAt(i) == s.charAt(firstStart)) {
                        secondStart = i;
                        firstStart++;
                        isChecking = true;
                    }
                }
                else {
                    if(s.charAt(i) == s.charAt(firstStart)) {
                        firstStart++;
                        if(secondStart == firstStart) {
                            result = secondStart;
                            break;
                        }
                    }
                    else {
                        firstStart = 0;
                        isChecking = false;
                    }
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}