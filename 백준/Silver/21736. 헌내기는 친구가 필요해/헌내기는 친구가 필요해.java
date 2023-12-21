import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Long> trees;
    public static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char [][] campus = new char[N][M];
        long max = 0;

        Point index = null;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = s.charAt(j);
                if(campus[i][j] == 'I') {
                    index = new Point(i, j);
                }
            }
        }

        int result = getTreeSize(index, campus);
        if(result == 0)
            bw.write("TT\n");
        else
            bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    public static int getTreeSize(Point index, char [][] campus) {
        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1,0,0};

        Queue<Point> queue = new LinkedList<>();
        boolean [][] visit = new boolean[N][M];
        int count = 0;

        queue.add(index);
        visit[index.x][index.y] = true;

        while (!queue.isEmpty()) {
            Point value = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = value.x + dx[i];
                int ny = value.y + dy[i];

                if(checkRound(nx, ny) && !visit[nx][ny] && campus[nx][ny] != 'X') {
                    if(campus[nx][ny] == 'P')
                        count++;
                    visit[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return count;
    }

    public static boolean checkRound(int x, int y) {
        return x >= 0 && y>= 0 && x < N && y < M;
    }
}