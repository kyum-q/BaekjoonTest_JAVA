import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("src/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            String s = sc.next();

            int isPalindrome = 1;

            int start = 0;
            int end = s.length()-1;

            while(start < end) {
                // 두 문자가 다를 경우
                if(s.charAt(start) != s.charAt(end)) {
                    isPalindrome = 0;
                    break;
                }

                start++;
                end--;
            }

            System.out.printf("#%d %d\n", test_case, isPalindrome);
        }
    }
}