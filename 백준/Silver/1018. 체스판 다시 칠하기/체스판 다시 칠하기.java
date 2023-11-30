import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int [][] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        chess = new int [N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'W')
                    chess[i][j] = 0;
                else
                    chess[i][j] = 1;
            }
        }

        int min = 9999999;
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                min = Math.min(min, getChangeCount(i,j));
            }
        }

        System.out.println(min);

        bw.flush();
        bw.close();
    }

    public static int getChangeCount(int x, int y) {
        int countW = 0;
        int countB = 0;

        int [][] chessW = new int[8][8];
        int [][] chessB = new int[8][8];

        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if(i==x && j==y) {
                    chessB[i-x][j-y] = 1;
                    chessW[i-x][j-y] = 0;
                }
                else {
                    int getX = i-x;
                    int getY = j-y-1;
                    if (j==y) {
                        getX = i-x-1;
                        getY = j-y;
                    }

                    chessB[i-x][j-y] = (chessB[getX][getY] + 1)%2;
                    chessW[i-x][j-y] = (chessW[getX][getY] + 1)%2;
                }

                if(chessB[i-x][j-y] != chess[i][j]) {
                    countB++;
                }
                if(chessW[i-x][j-y] != chess[i][j]) {
                    countW++;
                }
            }
        }

        return Math.min(countB, countW);
    }
}