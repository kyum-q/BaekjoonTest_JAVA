import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // N번 반복
        for(int i=0;i<N;i++) {
            // 두 수 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 최소 공약수 구하기
            int sum = (A>=B) ? A%B : B%A;
            int gcd = (A<B) ? A : B;
            while(sum > 0) {
                int temp = sum;
                sum = gcd % sum;
                gcd = temp;
            }

            // 최소 공약수를 가지고 최대 공배수 구하기
            int result = (A/gcd) * (B/gcd) * gcd;
            // 출력
            bw.write( result+ "\n");
        }
        bw.flush();
        bw.close();
    }
}
