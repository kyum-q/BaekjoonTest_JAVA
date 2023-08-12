import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, K 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 코인 입력
        int coins [] = new int[N];

        for(int i=0;i<N;i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        // 가장 큰 수부터 확인하면서 반복
        for(int i=N-1;i>=0;i--) {
            // 만약 현재 돈이 해당 코인으로 나누어진다면
            if(K / coins[i] > 0) {
                // count 증가 및 k에서 코인으로 계산한 금액 제외
                int newCount = K / coins[i];
                K = K - (newCount * coins[i]);
                count += newCount;
            }
        }

        System.out.println(count);
    }
}