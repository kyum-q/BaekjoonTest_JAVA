import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = getLCM(N,M);
            int result = -1;
            for (int i = (N>M)?x:y; i <= lcm; ) {
                if((i%M == x || (x == M && i%M == 0) ) && (i%N == y || (y == N && i%N == 0) ) ) {
                    result = i;
                    break;
                }
                i += Math.min(N,M);
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static int getLCM(int a, int b) {
        // 최소 공약수 구하기
        int sum = (a>=b) ? a%b : b%a;
        int gcd = Math.min(a, b);
        while(sum > 0) {
            int temp = sum;
            sum = gcd % sum;
            gcd = temp;
        }

        // 최소 공약수를 가지고 최대 공배수 구하기
        return (a/gcd) * (b/gcd) * gcd;
    }
}
