import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static HashMap<Integer, Integer> ladders, snakes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ladders = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladders.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        snakes = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snakes.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bw.write(BFS(N) + "\n");
        bw.flush();
        bw.close();
    }

    public static int BFS(int N) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> nextQueue = new LinkedList<>();
        boolean [] visit = new boolean[101];
        int [] counts = new int[101];

        queue.add(1);
        visit[1] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int nextQueueSize = 0;
            for (int i = 0; i < queueSize+nextQueueSize; i++) {

                int value;
                if(i < queueSize) value = queue.poll();
                else value = nextQueue.poll();

                if(ladders.containsKey(value)) {
                    int next = ladders.get(value);
                    counts[next] = count;
                    visit[next] = true;
                    nextQueue.add(next);
                    nextQueueSize++;

                    continue;
                }

                if(snakes.containsKey(value)) {
                    int next = snakes.get(value);
                    counts[next] = count;
                    visit[next] = true;
                    nextQueue.add(next);
                    nextQueueSize++;
                    continue;
                }

                for (int j = 1; j <= 6; j++) {
                    if(value + j <= 100 && !visit[value+j]) {
                        counts[value+j] = count+1;
                        visit[value+j] = true;
                        queue.add(value+j);
                    }
                }
            }

            count++;
        }
        return counts[100];
    }
}
