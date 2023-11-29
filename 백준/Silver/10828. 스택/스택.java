import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            String [] s = br.readLine().split(" ");

            switch (s[0]) {
                case "push":
                    stack.push(Integer.parseInt(s[1]));
                    break;
                case "pop":
                    if(stack.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(stack.pop() + "\n");
                    break;
                case "top":
                    if(stack.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(stack.peek() + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":

                    bw.write((stack.isEmpty()?1:0) + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}