import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static boolean [][] visit;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        char [][] colors = new char [N][N];
        char [][] nonColors = new char [N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                colors[i][j] = s.charAt(j);
                if(colors[i][j] == 'R')
                    nonColors[i][j] = 'G';
                else
                    nonColors[i][j] = colors[i][j];
            }
        }

        visit = new boolean[N][N];
        int colorCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    colorCount++;
                    colorBFS(new Point(i, j), colors, colors[i][j]);
                }
            }
        }

        visit = new boolean[N][N];
        int nonColorCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    nonColorCount++;
                    colorBFS(new Point(i, j), nonColors, nonColors[i][j]);
                }
            }
        }

        bw.write(colorCount + " " + nonColorCount);

        bw.flush();
        bw.close();
    }

    public static void colorBFS(Point p, char [][] colors, char color) {
        Queue<Point> queue = new LinkedList<>();
        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1,0,0};

//        char color = colors[p.x][p.y];
        visit[p.x][p.y] = true;
        queue.add(p);

        while (!queue.isEmpty()) {
            Point newP = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = newP.x + dx[i];
                int nextY = newP.y + dy[i];

                if(checkRound(nextX, nextY) && color==colors[nextX][nextY] && !visit[nextX][nextY]) {
                    visit[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
    }

    public static boolean checkRound(int x, int y) {
        return x >= 0 && y>=0 && x < N && y < N;
    }
}
