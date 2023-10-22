import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 남은 일 수
        int N = Integer.parseInt(br.readLine());

        // dp 값
        int [] dp = new int[N+2];

        int max = 0;

        // N일에 따른 상담 일정
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if(max < dp[i])
                max = dp[i];

            if (t+i < N + 2) {
                dp[t+i] = Math.max(dp[t+i], max + p);
            }
        }

        if(max < dp[N+1])
            max = dp[N+1];

        System.out.println(max);
    }

}