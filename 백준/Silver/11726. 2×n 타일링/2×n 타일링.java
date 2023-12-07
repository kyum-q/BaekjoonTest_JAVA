import java.io.*;

public class Main {
    public static int Div = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] dp = new int[1001];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        bw.write(dp[N] + "\n");

        bw.flush();
        bw.close();
    }
}