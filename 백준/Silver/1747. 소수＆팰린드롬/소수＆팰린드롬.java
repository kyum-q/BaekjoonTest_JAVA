import java.util.Scanner;

public class Main {

    public static long [] nums;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        // N 입력
        int N = sc.nextInt();

        // 배열 생성
        nums = new long[10000001];
        for(int i=0;i<10000001;i++) {
            nums[i] = i;
        }

        // 소수 구하기
        for(int i=2;i<10000001;i++) {
            if(nums[i] > 1) {
                distinction(i);
            }
        }

        // N 이상의 값 중에서 소수이면서 팰린드롬 수 구하기
        for(int i=N;i<10000001;i++) {
            // 소수인지 판단
            if(nums[i] > 1) {
                // 팰린드롬 수인지 판단하기 위해 문자열로 변환
                String s = String.valueOf(nums[i]);

                // 팰린드롬 수인지 알려주는 변수
                boolean isPalindrome = true;
                // 문자열의 앞글자와 끝글자 비교
                for(int j=0;j<=s.length()/2;j++) {
                    // 두 글자가 다를 경우 isPalindrome를 false로
                    if(s.charAt(j) != s.charAt(s.length()-j-1)) {
                        isPalindrome = false;
                        break;
                    }
                }
                // 팰린드롬 수일 경우 출력 후 반복 종료
                if(isPalindrome) {
                    System.out.println(nums[i]);
                    break;
                }
            }
        }
    }

    public static void distinction(int i) {
        for(int j=i+i;j<10000001;j=j+i) {
            nums[j] = 0;
        }
    }
}

