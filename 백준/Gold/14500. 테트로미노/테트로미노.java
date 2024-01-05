import java.io.*;
import java.util.*;

public class Main {
    public static int[][] nums;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(new int[]{0, 1, 2, 3}, new int[]{0, 0, 0, 0}));
        blocks.add(new Block(new int[]{0, 1, 2, 2}, new int[]{0, 0, 0, -1}));
        blocks.add(new Block(new int[]{0, 0, 1, 1}, new int[]{0, 1, 0, 1}));
        blocks.add(new Block(new int[]{0, 1, 1, 2}, new int[]{0, 0, -1, -1}));
        blocks.add(new Block(new int[]{0, 1, 2, 1}, new int[]{0, 0, 0, 1}));

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (Block block : blocks) {
                    max = Math.max(max, block.getCount(j, i));
                }
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }

    public static class Block {
        int [] dx;
        int [] dy;

        public Block(int [] dx, int [] dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public int getCount(int sx, int sy) {
            int maxCount = 0;
            int count;

            int []ndx = {1,1,-1,-1};
            int []ndy = {1,-1,1,-1};

            for (int i = 0; i < 4; i++) {
                count = 0;
                for (int j = 0; j < 4; j++) {
                    int nx = sx + dx[j] * ndx[i];
                    int ny = sy + dy[j] * ndy[i];
                    if (!checkRound(nx, ny)) {
                        continue;
                    }
                    count += nums[ny][nx];
                }
                maxCount = Math.max(maxCount, count);
            }

            for (int i = 0; i < 4; i++) {
                count = 0;
                for (int j = 0; j < 4; j++) {
                    int nx = sx + dy[j] * ndx[i];
                    int ny = sy + dx[j] * ndy[i];
                    if (!checkRound(nx, ny)) {
                        continue;
                    }
                    count += nums[ny][nx];
                }
                maxCount = Math.max(maxCount, count);
            }

            return maxCount;
        }
    }

    public static boolean checkRound(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}
