import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static long [] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // M, N 입력
        long M = sc.nextLong();
        long N = sc.nextLong();

        nums = new long[10000001];

        // 0 이상 N 이하 배열 제작
        for (long i = 0; i < 10000001; i++) {
            nums[(int) i] = i;
        }

        // 2부터 N까지 확인
        for (long i = 2; i <= Math.sqrt(10000001); i++) {
            // 해당 값이 0이 아닐 때 출력 ( 0이면 소수가 아니라 제거된 값 )
            if (nums[(int) i] != 0) {
                distinction((int) i);
            }
        }

        int count = 0;

        // 2부터 N까지 확인
        for (long i = 2; i < 10000001; i++) {
            Long num = nums[(int) i];
            //해당 값이 1보다 클 때 count 증가 ( 0이면 소수가 아니라 제거된 값 )
            if (num > 1) {
                long newNum = num;
                // num^k <= N 을 비교하기에는 num^k가 long타입을 넘을 수 있음
                // 그러므로, num^(k-1) * num <= N --> num <= N/num^(k-1) 로 비교
                while ((double) num <= (double) N / (double)newNum) {
                    if((double) num >= (double) M / (double) newNum) {
                        // 값 안에 존재하는 거의 소수일 경우 count 증가
                        count++;
                    }
                    newNum *= num;
                }
            }
        }

        System.out.println(count);
    }

    public static void distinction(int i) {
        for (long j = i+i; j < 10000001; j = j+i) {
            nums[(int) j] = 0L;
        }
    }
}