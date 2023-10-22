import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 남은 일 수
        int N = Integer.parseInt(br.readLine());

        // dp 값
        int [] dp = new int[N+2];

        // 상담 일정 Array
        Talk [] talks = new Talk[N+2];

        // N일에 따른 상담 일정
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            talks[i] = new Talk(t, p);
        }

        int max = 0;
        for (int i = 1; i < N+2; i++) {

            if(max < dp[i])
                max = dp[i];

            int day = (i>N) ? 0 : i + talks[i].time;
            int pay = (i>N) ? 0 : talks[i].pay;
            if (day < N + 2) {
                dp[day] = Math.max(dp[day], max + pay);
            }
        }

        System.out.println(max);
    }

    public static class Talk {
        public int time;
        public int pay;
        public Talk(int time, int pay) {
            this.time = time;
            this.pay = pay;
        }

    }
}