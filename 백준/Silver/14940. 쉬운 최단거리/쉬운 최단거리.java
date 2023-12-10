import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int [][] map = new int[n][m];
        int finalN = 0;
        int finalM = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    finalN = i;
                    finalM = j;
                }
            }
        }

        int [][] newMap = BFS(map, finalN, finalM);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0)
                    newMap[i][j] = 0;
                bw.write(newMap[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static int [][] BFS(int [][] map, int x, int y) {
        boolean [][] visit = new boolean[n][m];
        int [][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(newMap[i], -1);
        }

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x, y));
        visit[x][y] = true;
        newMap[x][y] = 0;

        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1,0,0};

        int count = 1;
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int q = 0; q < queueSize; q++) {
                Point value = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = value.x + dx[i];
                    int ny = value.y + dy[i];

                    if (isCheckRound(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1) {
                        newMap[nx][ny] = 0;
                        visit[nx][ny] = true;

                        queue.add(new Point(nx, ny));
                        newMap[nx][ny] = count;
                    }
                }
            }
            count++;
        }

        return newMap;
    }

    public static boolean isCheckRound(int x, int y) {
        return x >= 0 && y>= 0 && x < n && y < m;
    }
}