import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.heap > o2.heap) {
                    return 1;
                }
                else if(o1.heap < o2.heap) {
                    return -1;
                }
                else {
                    if(o1.value > o2.value) {
                        return 1;
                    }
                    else
                        return -1;
                }
            }
        });

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // N 만큼 숫자 입력
        for(int i=0;i<N;i++) {
            // 수 입력
            int num = Integer.parseInt(br.readLine());

            // 입력 값이 0일 경우, 가장 작은 값 출력
            if(num == 0) {
                // 배열이 비어있으면 0 출력
                if(queue.isEmpty()) {
                    bw.write(0+"\n");
                }
                else {
                    bw.write(queue.poll().value+"\n");
                }
            }
            // 입력 값이 0이 아닐 경우 배열 삽입
            else {
                queue.add(new Node(num));
            }
        }
        bw.flush();
        bw.close();
    }
}

class Node {
    public int value;
    public int heap;
    public Node(int value) {
        this.value = value;

        if(value > 0)
            this.heap = value;
        else
            this.heap = -value;
    }
}