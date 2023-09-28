import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 각 정점에 연결되 있는 점 리스트
        ArrayList<Integer> [] lists = new ArrayList [N];
        for(int i=0;i<N;i++) {
            lists[i] = new ArrayList<>();
        }

        // 간선 입력
        ArrayList<Node> lines = new ArrayList<>();
        for(int i=0;i<N-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            lists[a].add(b);
            lists[b].add(a);
            lines.add(new Node(a,b));
        }

        // 질문 개수 Q 입력
        int Q = Integer.parseInt(br.readLine());

        // 질문 답변
        for(int i=0;i<Q;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken())-1;

            // k가 단절점인지 체크
            if(t == 1) {
                if(lists[k].size() >= 2){
                    bw.write("yes\n");
                }else {
                    bw.write("no\n");
                }
            }
            // k번째 간선이 단절선인지 체크
            else {
                bw.write("yes\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static class Node {
        public int a;
        public int b;
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}