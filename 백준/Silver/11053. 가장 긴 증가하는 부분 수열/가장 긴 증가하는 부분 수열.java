import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 크기(N) 입력
        int N = Integer.parseInt(br.readLine());

        // 수열 입력
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            int len = 0;
            for (int j = nodes.size() - 1; j >= 0; j--) {
                Node node = nodes.get(j);
                if (node.num > nums[i] && len < node.len)
                    len = node.len;
            }
            nodes.add(new Node(nums[i], len + 1));
        }

        Collections.sort(nodes);

        int result = nodes.get(0).len;

        bw.write(result + "\n");
        bw.flush();
        bw.close();

    }

    public static class Node implements Comparable<Node> {
        public int num;
        public int len;

        public Node(int num, int len) {
            this.num = num;
            this.len = len;
        }

        @Override
        public int compareTo(Node n) {
            return n.len - this.len;
        }
    }
}