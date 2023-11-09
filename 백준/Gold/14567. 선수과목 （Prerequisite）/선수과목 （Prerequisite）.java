import java.awt.desktop.QuitEvent;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 과목 수 N, 선수 조건의 수 M
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int [N+1];

        ArrayList<Node> nodes = new ArrayList<>();

        for(int i=0;i<M;i++) {
            // B를 들으려면 A를 수강해야함
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            nodes.add(new Node(A,B));
        }

        Collections.sort(nodes);

        for(Node n : nodes) {
            dp[n.B] = Math.max(dp[n.A] + 1, dp[n.B]);
        }

        for(int i=1;i<=N;i++) {
            bw.write(dp[i]+1 + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int A;
        int B;
        public Node(int A, int B) {
            this.A = A;
            this.B = B;
        }
        @Override
        public int compareTo(Node n2) {
            if(this.B == n2.B)
                return this.A - n2.A;
            return this.B - n2.B;
        }
    }
}