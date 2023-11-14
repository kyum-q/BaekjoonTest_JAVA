import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();

            int [] parentNum = new int[2];
            parentNum[0] = 1;

            System.out.println("#" + test_case);

            for(int i=1;i<=N;i++) {
                int [] currentNum = new int [i+2];
                for(int j=1;j<=i;j++) {
                    currentNum[j] = parentNum[j-1] + parentNum[j];
                }

                Arrays.stream(currentNum).forEach(n -> printNums(n));
                System.out.println();

                parentNum = currentNum;
            }
        }
    }

    public static void printNums(int n) {
        if(n > 0)
            System.out.print(n+" ");
    }
}
