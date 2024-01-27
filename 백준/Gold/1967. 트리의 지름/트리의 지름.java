import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Edge> [] edges = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[a].add(new Edge(b,w));
            edges[b].add(new Edge(a,w));
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            boolean [] visited = new boolean[N+1];
            result = Math.max(result, DFS(i, visited, edges));
        }

        br.close();

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    public static int DFS(int n, boolean [] visited, ArrayList<Edge> [] edges) {
        int sum = 0;

        visited[n] = true;
        for(Edge e : edges[n]) {
            if(!visited[e.end]) {
                sum = Math.max(DFS(e.end, visited, edges) + e.w, sum);
            }
        }
        visited[n] = false;

        return sum;
    }

    public static class Edge {
        int end;
        int w;
        public Edge(int end, int w) {
            this.end = end;
            this.w = w;
        }
    }
}