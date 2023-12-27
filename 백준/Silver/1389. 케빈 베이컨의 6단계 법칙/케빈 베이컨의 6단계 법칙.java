import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        friends = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        int min = 99999999;
        int minIndex = 0;
        for (int i = 1; i <= N; i++) {
            int value = BFS(i, N);
            if (value < min) {
                min = value;
                minIndex = i;
            }
        }

        bw.write(minIndex + "\n");
        bw.flush();
        bw.close();
    }

    public static int BFS(int index, int N) {
        boolean[] visit = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        int sum = 0;

        visit[index] = true;
        queue.add(index);

        int count = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int q = 0; q < queueSize; q++) {
                Integer newIndex = queue.poll();
                for (int value : friends[newIndex]) {
                    if (!visit[value]) {
                        visit[value] = true;
                        queue.add(value);
                        sum += count;
                    }
                }
            }
            count++;
        }

        return sum;
    }
}
