import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        Stack<Integer> stack = new Stack<Integer>();

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 가장 높은 pop된 숫자 기억
        int maxPopNum = 0;

        // N개 수 입력
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());

            if(maxPopNum == -1) {
                continue;
            }

            // maxPopNum < num
            if(maxPopNum < num) {
                // num까지 스택에 넣기
                for(int j=maxPopNum+1;j<=num;j++) {
                    stack.push(j);
                    result.append("+");
                }
                // num pop
                stack.pop();

                //maxPopNum 바꾸기
                maxPopNum = num;
            }
            // maxPopNum > num
            else {
                int popNum = stack.pop();
                if(popNum != num) {
                    //불가능 한 경우면 maxPopNum = -1로, break
                    maxPopNum = -1;
                    continue;
                }
            }
            result.append("-");
        }

        if(maxPopNum == -1) {
            System.out.println("NO");
        }
        else {
            for(int i=0;i<result.length()-1;i++) {
                System.out.println(result.charAt(i));
            }
            System.out.print(result.charAt(result.length()-1));
        }
    }
}