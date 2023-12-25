import java.io.*;
import java.util.*;

public class Main {
    public static int [][] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        nums = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            BFS(i, N);
            for (int j = 0; j < N; j++) {
                bw.write(nums[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void BFS(int index, int N) {
        boolean [] visit = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(index);

        while (!queue.isEmpty()) {
            int value = queue.poll();
            for (int i = 0; i < N; i++) {
                if(nums[value][i] == 1 && !visit[i]) {
                    nums[index][i] = 1;
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}