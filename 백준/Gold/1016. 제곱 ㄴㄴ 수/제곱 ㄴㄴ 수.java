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
            long newPow = pow * Math.max((min / pow), 1);

            if (newPow < min) {
                newPow += i * i;
            }
            
            for(long j=newPow;j<=max;j+=pow) {
                check[(int) (j - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < range; i++) {
            if (!check[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
