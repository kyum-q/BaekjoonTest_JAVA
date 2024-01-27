import java.io.*;
import java.util.*;

public class Main {
    public static int [] results;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<Edge> [] edges = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[u].add(new Edge(v,w));
        }

        results = new int[V+1];
        Arrays.fill(results, Integer.MAX_VALUE);

        BFS(V, K, edges);

        for (int i = 1; i <= V; i++) {
            if(results[i] == Integer.MAX_VALUE)
                bw.write("INF\n");
            else
                bw.write(results[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void BFS(int V, int start, ArrayList<Edge> [] edges) {
        Queue<Edge> queue = new PriorityQueue<>();
        boolean [] visited = new boolean[V+1];

        queue.add(new Edge(start, 0));
        results[start] = 0;

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (!visited[edge.v]) {
                visited[edge.v] = true;
                for (Edge e : edges[edge.v]) {
                    results[e.v] = Math.min(results[e.v], e.w + edge.w);
                    queue.add(new Edge(e.v, e.w + edge.w));
                }
            }
        }
    }

    public static class Edge implements Comparable<Edge> {
        int v;
        int w;
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            if(w == o.w) {
                return v - o.v;
            }
            return w - o.w;
        }
    }
}