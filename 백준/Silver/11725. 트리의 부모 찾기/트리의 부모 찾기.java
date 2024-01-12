import java.io.*;
import java.util.*;

public class Main {
    public static int [] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> [] nears = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            nears[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nears[a].add(b);
            nears[b].add(a);
        }

        result = new int[N+1];
        BFS(nears, N);

        for (int i = 2; i <= N; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
    public static void BFS(ArrayList<Integer> [] nears, int N) {
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visit = new boolean[N+1];

        visit[1] = true;
        queue.add(1);

        while (!queue.isEmpty()) {
            int value = queue.poll();

            ArrayList<Integer> near = nears[value];

            for(int n : near) {
                if(!visit[n]) {
                    result[n] = value;
                    visit[n] = true;
                    queue.add(n);
                }
            }
        }

    }
}
