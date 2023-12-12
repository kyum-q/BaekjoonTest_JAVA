import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [][] tomatos = new int[M][N];

        ArrayList<Point> ripe = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tomatos[i][j] = Integer.parseInt(st.nextToken());
                if(tomatos[i][j] == 1) {
                    ripe.add(new Point(i, j));
                }
            }
        }

        int count = BFS(ripe, tomatos);

        boolean isAllRipe = true;
        for (int i = 0; i < M; i++) {
            if(!isAllRipe)
                break;
            for (int j = 0; j < N; j++) {
                if(tomatos[i][j] == 0) {
                    isAllRipe = false;
                    break;
                }
            }
        }

        if(isAllRipe)
            bw.write(count +"\n");
        else
            bw.write("-1\n");

        bw.flush();
        bw.close();
    }

    public static int BFS(ArrayList<Point> ripe, int [][] tomatos) {
        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1,0,0};

        int count = 0;
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < ripe.size(); i++) {
            queue.add(ripe.get(i));
        }

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Point value = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = value.x + dx[j];
                    int ny = value.y + dy[j];

                    if(checkRound(nx, ny) && tomatos[nx][ny] == 0) {
                        tomatos[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            count++;
        }

        return count-1;
    }

    public static boolean checkRound(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}