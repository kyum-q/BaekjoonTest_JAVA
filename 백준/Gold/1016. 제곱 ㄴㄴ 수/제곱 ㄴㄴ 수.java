import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        // min, max 입력
        long min = sc.nextLong();
        long max = sc.nextLong();
        int range = (int) (max - min + 1);

        // 배열 생성
        boolean[] check = new boolean[range];
        
        for (long i = 2; i * i<= max; i++) {
            // 제곱 수
            long pow = i * i;
            // MIN보다 큰 제곱 수 알아내기
            long newPow = pow * Math.max((min / pow), 1);

            // 만약 새로 구한 제곱 수도 min보다 작을 경우 제곱 한번 더 더하기
            if (newPow < min) {
                newPow += pow;
            }
            
            // max 값까지 제곱수의 배수 확인하기
            for(long j=newPow;j<=max;j+=pow) {
                check[(int) (j - min)] = true;
            }
        }

        // 개수 알아내기
        int count = 0;
        for (int i = 0; i < range; i++) {
            if (!check[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
