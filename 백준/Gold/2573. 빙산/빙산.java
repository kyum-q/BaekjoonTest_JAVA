import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int [][] lists;
    public static boolean [][] visited;
    public static boolean checkICE;
    public static int [] dx = {1,0,-1,0};
    public static int [] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lists = new int [N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lists[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean checkResult = false;
        int result = 0;
        checkICE = true;
        while(checkICE) {
            result++;
            int count = 0;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(!visited[i][j] && lists[i][j] > 0) {
                        BFS(i, j);
                        count++;
                    }
                }
            }

            int [][] minus = new int [N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(visited[i][j] && lists[i][j] > 0) {
                        for (int k = 0; k < 4; k++) {
                            int checkX = i + dx[k];
                            int checkY = j + dy[k];
                            if (checkRound(checkX, checkY) && lists[checkX][checkY] == 0) {
                                minus[i][j]--;
                            }
                        }
                    }
                }
            }
            checkICE = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(minus[i][j] < 0) {
                        checkICE = true;
                        lists[i][j] = Math.max(lists[i][j] + minus[i][j] , 0);
                    }
                }
            }
            if(count >= 2) {
                checkResult = true;
                break;
            }
        }

        if(checkResult)
            System.out.println(result-1);
        else
            System.out.println(0);
    }
    public static void BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node value = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = value.x + dx[i];
                int newY = value.y + dy[i];
                if(checkRound(newX, newY) && lists[newX][newY] > 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Node(newX, newY));
                }
            }
        }
    }

    public static boolean checkRound(int newX, int newY) {
        return (newX >= 0 && newY >= 0 && newX < N && newY < M);
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