import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [][] dp = new int[N][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            dp[0][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int color = Integer.parseInt(st.nextToken());
                dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + color;
            }
        }

        bw.write(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]) + "\n");

        bw.flush();
        bw.close();
    }
}