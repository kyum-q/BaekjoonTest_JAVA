import java.io.*;
import java.util.*;

public class Main {
    public static int M,N,H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int [][][] tomato = new int[M][N][H];
        ArrayList<Location> ripeTomato = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomato[k][j][i] = Integer.parseInt(st.nextToken());
                    if(tomato[k][j][i] == 1) {
                        ripeTomato.add(new Location(k,j,i));
                    }
                }
            }
        }

        System.out.println(BFS(ripeTomato, tomato));
    }

    static public int BFS(ArrayList<Location> ripe, int [][][] tomato) {
        int count = 0;
        Queue<Location> queue = new LinkedList<>();
        boolean [][][] visited = new boolean[M][N][H];

        for (int i = 0; i < ripe.size(); i++) {
            Location l = ripe.get(i);
            queue.add(l);
            visited[l.x][l.y][l.z] = true;
        }

        int [] dx = {1,-1,0,0,0,0};
        int [] dy = {0,0,1,-1,0,0};
        int [] dz = {0,0,0,0,1,-1};

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int q = 0; q < queueSize; q++) {
                Location l = queue.poll();

                for (int i = 0; i < 6; i++) {
                    int x = l.x + dx[i];
                    int y = l.y + dy[i];
                    int z = l.z + dz[i];
                    if (x >= 0 && x < M && y >= 0 && y < N && z >= 0 && z < H
                            && tomato[x][y][z] == 0 && !visited[x][y][z]) {
                        queue.add(new Location(x, y, z));
                        tomato[x][y][z] = 1;
                        visited[x][y][z] = true;
                    }
                }
            }
            count++;
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(tomato[k][j][i] == 0) {
                        return -1;
                    }
                }
            }
        }
        return count-1;
    }

    public static class Location {
        int x, y, z;
        public Location(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}