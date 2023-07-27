import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 출력 배열
        int [] result = new int[N];

        // 스택에 넣기
        Stack<Node> stack = new Stack<>();
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek().value < num) {
                result[stack.pop().index] = num;
            }
            stack.push(new Node(i, num));
        }
        while(!stack.isEmpty()) {
            result[stack.pop().index] = -1;
        }

        for(int i=0;i<N;i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}

class Node{
    public int index;
    public int value;
    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}