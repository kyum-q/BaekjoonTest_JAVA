import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int [][] stikers = new int[2][N];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    stikers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int [][] dp = new int[2][N];
            dp[0][0] = stikers[0][0];
            dp[1][0] = stikers[1][0];
            if( N > 1) {
                dp[0][1] = dp[1][0] + stikers[0][1];
                dp[1][1] = dp[0][0] + stikers[1][1];
            }
            
            for (int i = 2; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                        dp[j][i] = Math.max(dp[(j + 1) % 2][i - 1] + stikers[j][i], dp[(j + 1) % 2][i - 2] + stikers[j][i]);
                }
            }

            bw.write(Math.max(dp[0][N-1], dp[1][N-1]) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
    
}