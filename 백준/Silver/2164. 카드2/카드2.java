import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new LinkedList<>();

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 수 입력
        for(int i=0;i<N;i++) {
            deque.add(i+1);
        }

        // 카드 지우고 넘기고 반복
        while(deque.size() > 1) {
            deque.pop();
            deque.addLast(deque.pop());
        }

        System.out.println(deque.pop());
    }
}
