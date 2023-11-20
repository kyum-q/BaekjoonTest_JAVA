import java.io.*;
import java.util.*;

public class Main {
    public static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(BFS());
    }

    static public int BFS() {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[100001];

        queue.add(N);
        visited[N] = true;

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int value = queue.poll();

                // 동생을 찾은 경우
                if (value == K) {
                    queue.clear();
                    break;
                }
                // 뒤로 걷기
                if (value - 1 >= 0 && !visited[value - 1]) {
                    queue.add(value - 1);
                    visited[value - 1] = true;
                }
                // 앞으로 걷기
                if (value + 1 <= 100000 && !visited[value + 1]) {
                    queue.add(value + 1);
                    visited[value + 1] = true;
                }
                // 순간이동
                if (value * 2 <= 100000 && !visited[value * 2]) {
                    queue.add(value * 2);
                    visited[value * 2] = true;
                }
            }
            count++;
        }

        return count - 1;
    }

}