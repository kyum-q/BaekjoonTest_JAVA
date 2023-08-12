import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, K 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;

        int coins [] = new int[N];

        for(int i=0;i<N;i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=N-1;i>=0;i--) {
            if(K / coins[i] > 0) {
                int newCount = K / coins[i];
                K = K - (newCount * coins[i]);
                count += newCount;
            }
        }

        System.out.println(count);
    }
}