import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        long N = Long.parseLong(br.readLine());
        
        // 현재 N과 최대공약수가 1인 k 개수를 나타내는 count 값 초기화
        long count = N;

        // 제곱근까지만 반복
        for(long i = 2; i * i <= N; i++) {
            // N % i가 0일 경우, i는 N의 약수
            if(N % i == 0) {
                // N이하의 i가 약수인 다른 수들 개수를 빼기
                count -= count / i;
                // 지금 N값에서 해당 약수를 빼기 (중복 제거 발생 방지를 위해)
                while(N % i == 0) {
                    N /= i;
                }
            }
        }

        // 아직도 약수가 남아 있을 경우 한 번 더 빼서 count 마무리
        if(N > 1) {
            count -= count / N;
        }

        System.out.println(count);
    }
}
