import java.io.*;
import java.util.*;

public class Main {
    public static int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(BFS(N, K) + "\n");
        bw.flush();
        bw.close();
    }

    public static int BFS(int N, int K) {
        Queue<Result> q = new PriorityQueue<>();
        boolean[] visited = new boolean[MAX];

        q.add(new Result(N, 0));

        while (!q.isEmpty()) {
            Result value = q.poll();
            if (value.n == K) {
                return value.count;
            }

            if (checkRound(value.n) && !visited[value.n]) {
                visited[value.n] = true;

                q.add(new Result(value.n + 1, value.count + 1));
                q.add(new Result(value.n - 1, value.count + 1));
                q.add(new Result(value.n * 2, value.count));

            }
        }
        return 0;
    }

    public static boolean checkRound(int n) {
        return n >= 0 && n < MAX;
    }

    public static class Result implements Comparable<Result>{
        int n;
        int count;
        public Result(int n, int count) {
            this.n = n;
            this.count = count;
        }

        @Override
        public int compareTo(Result o) {
            if(count == o.count)
                return n - o.n;
            return count - o.count;
        }
    }
}