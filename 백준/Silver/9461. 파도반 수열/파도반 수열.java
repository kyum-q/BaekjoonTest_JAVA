import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        long [] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            bw.write(dp[N] + "\n");
        }
        bw.flush();
        bw.close();
    }
}

/*

1 = 1
2 = 1 = p1
3 = 1 = p2
4 = 2 = p1 + p3
5 = 2 = p4
6 = 3 = p5 + p1
7 = 4 = p6 + p2
8 = 5 = p7 + p3
9 = 7 = p8 + p4
10 = 9 = p9 + p5
11 = 12 = p10 + p6
12 = 16 = p11 + p7
13 = 21 = p12 + p8
N = p[N-1] + p[N-5]
 */