import java.io.*;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int [] stairs = new int[N+1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int [] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = stairs[1];
        if(N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
        }

        bw.write(dp[N] + "\n");

        bw.flush();
        bw.close();
    }

}