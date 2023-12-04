import java.io.*;

public class Main {
    public static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[41][2];
        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};
        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            bw.write(dp[n][0] + " " + dp[n][1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}