import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        bw.write(BFS(a,b) + "\n");

        bw.flush();
        bw.close();
    }

    public static long BFS(long a, long b) {
        Queue<Long> queue = new LinkedList<>();
        queue.add(a);

        long count = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                long value = queue.poll();

                if (value == b) {
                    return count;
                }

                if (value * 2 <= b) {
                    queue.add(value * 2);
                }
                if (value * 10 + 1 <= b) {
                    queue.add(value * 10 + 1);
                }
            }
            count++;
        }

        return -1;
    }
}