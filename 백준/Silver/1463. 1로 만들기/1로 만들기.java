import java.io.*;

public class Main {
    public static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[1000001];
        dp[0] = 9999;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < 1000001; i++) {
            dp[i] = dp[i-1];
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]);
            }
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]);
            }
            dp[i] = dp[i]+1;
        }

        int N = Integer.parseInt(br.readLine());
        bw.write(dp[N] + "\n");

        bw.flush();
        bw.close();
    }
}