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

        int [][] map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j-1);
            }
        }

        bw.write(BFS(map) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static long BFS(int [][] map) {
        Queue<Node> queue = new LinkedList<>();
        boolean [][][] visited = new boolean[2][N+1][M+1];
        boolean isFinish = false;
        long count = 0;

        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};

        queue.add(new Node(1,1, false));
        visited[0][1][1] = true;
        visited[1][1][1] = true;
        while (!queue.isEmpty() && !isFinish) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node value = queue.poll();
                int passWall = (value.passWall)?1:0;

                if(value.x == N && value.y == M) {
                    isFinish = true;
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = value.x + dx[j];
                    int ny = value.y + dy[j];

                    if(inRound(nx,ny) && !visited[passWall][nx][ny]) {
                        visited[passWall][nx][ny] = true;
                        if(map[nx][ny] == '0') {
                            queue.add(new Node(nx,ny, value.passWall));
                        }
                        else if(!value.passWall) {
                            queue.add(new Node(nx,ny, true));
                        }
                    }
                }
            }
            count++;
        }

        if(isFinish)
            return count;
        return -1;
    }

    public static boolean inRound(int x, int y) {
        return x > 0 && y > 0 && x <= N && y <= M;
    }

    public static class Node {
        int x;
        int y;
        boolean passWall;

        public Node(int x, int y, boolean passWall) {
            this.x = x;
            this.y = y;
            this.passWall = passWall;
        }
    }
}