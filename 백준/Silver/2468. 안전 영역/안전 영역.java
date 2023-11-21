import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int [][] lists;
    public static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int max = 0;

        lists = new int [N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lists[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(lists[i][j], max);
            }
        }

        int result = 0;

        for (int m = 0; m <= max; m++) {
            int newResult = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && lists[i][j] > m) {
                        BFS(i, j, m);
                        newResult++;
                    }
                }
            }
            result = Math.max(result, newResult);
        }

        System.out.println(result);
    }
    public static void BFS(int x, int y, int rainHeight) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node value = queue.poll();

            int [] dx = {1,0,-1,0};
            int [] dy = {0,1,0,-1};

            for (int i = 0; i < 4; i++) {
                int newX = value.x + dx[i];
                int newY = value.y + dy[i];
                if(newX >= 0 && newY >= 0 && newX < N && newY < N
                        && lists[newX][newY] > rainHeight && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Node(newX, newY));
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}