import java.io.*;
import java.util.*;

public class Main {
    public static int [][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Edge> [] edges = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        result = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[a].add(new Edge(b,w));
            result[a][b] = w;
        }

        for (int i = 1; i <= N; i++) {
            BFS(i, edges);
        }

        br.close();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static void BFS(int start, ArrayList<Edge> [] edges) {
        Queue<Edge> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[edges.length];

        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge value = queue.poll();

            if(!visited[value.end]) {
                visited[value.end] = true;
                for (Edge e : edges[value.end]) {
                    if (!visited[e.end]) {
                        if(result[start][e.end] != 0)
                            result[start][e.end] = Math.min(value.w + e.w, result[start][e.end]);
                        if(result[start][e.end] == 0)
                            result[start][e.end] = value.w + e.w;

                        queue.add(new Edge(e.end, value.w + e.w));
                    }
                }
            }
        }
    }

    public static class Edge implements Comparable<Edge> {
        int end;
        int w;
        public Edge(int end, int w) {
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            if(w == o.w)
                return end - o.end;
            return w - o.w;
        }
    }
}