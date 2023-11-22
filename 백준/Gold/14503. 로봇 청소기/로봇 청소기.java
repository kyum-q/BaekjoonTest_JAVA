import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count = 1;
    static int map[][];
    static int dy[] = {-1, 0, 1, 0};  // 북동남서
    static int dx[] = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 방향 0북 , 1동, 2남, 3서

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(x, y, d);
        System.out.println(count);
    }

    public static void dfs(int y, int x, int direction) {
        map[y][x] = -1;

        // 닦을 곳이 있어서 앞으로
        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;

            int ny = y + dy[direction];
            int nx = x + dx[direction];
            if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[ny][nx] == 0) {
                count++;
                dfs(ny, nx, direction);
                return;
            }
        }

        // 닦을 곳이 없어서 뒤로
        int back = (direction + 2) % 4;

        int by = y + dy[back];
        int bx = x + dx[back];
        if (bx >= 0 && by >= 0 && bx < M && by < N && map[by][bx] != 1) {
            dfs(by, bx, direction);
        }
    }
}
