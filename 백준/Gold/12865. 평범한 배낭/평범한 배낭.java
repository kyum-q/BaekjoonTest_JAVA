import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            products.add(new Product(w,v));
        }


        int [][] dp = new int [N+1][K+1];

        for (int i = 1; i <= N; i++) {
            Product p = products.get(i-1);
            for(int j=1; j<=K; j++) {
                dp[i][j] = dp[i-1][j];
                if(j - p.w >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-p.w] + p.v);
                }
            }
        }

        System.out.println(dp[N][K]);
    }

    public static class Product {
        int w;
        int v;
        public Product(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}