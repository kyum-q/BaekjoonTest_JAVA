import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 두 수의 1의 개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 최소 공약수의 1의 개수 구하기
        long sum = (A >= B) ? A % B : B % A;
        long gcd = Math.min(A, B);

        while (sum > 0) {
            long temp = sum;
            sum = gcd % sum;
            gcd = temp;
        }

        // 실제 최대 공약수 제작
        for(int i=0;i<gcd;i++) {
            bw.write("1");
        }
        bw.flush();
        bw.close();

    }
}
