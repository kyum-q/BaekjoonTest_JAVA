import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean [][] check = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                check[y][x] = true;
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(check[i][j]) {
                        BFS(check, j, i);
                        count++;
                    }
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void BFS(boolean [][] check, int x, int y) {
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x, y));
        check[y][x] = false;

        while(!queue.isEmpty()) {
            Point value = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = value.x + dx[i];
                int ny = value.y + dy[i];

                if(isOverRound(nx, ny) && check[ny][nx]) {
                    queue.add(new Point(nx, ny));
                    check[ny][nx] = false;
                }
            }
        }
    }

    public static boolean isOverRound(int x, int y) {
        return (x >= 0 && y >= 0 && x < M && y < N);
    }
}