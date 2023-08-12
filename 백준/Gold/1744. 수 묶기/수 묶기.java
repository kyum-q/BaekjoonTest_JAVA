import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 수 입력
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(nums);

        // 최대 합
        int result = 0;

        // i==0일때까지 반복
        int i = N - 1;
        while (i >= 0 && nums[i] > 0) {
            // i-1이 0보다 크거나 같을 때
            if (i - 1 >= 0) {
                //두 수의 곱이 두수의 합보다 크면
                if (nums[i] * nums[i - 1] > nums[i] + nums[i - 1]) {
                    // 결과에 두수의 곱을 더하고, i 두개 넘어가기
                    result += nums[i] * nums[i - 1];
                    i -= 2;
                    // 두 수의 합이 더 크면
                } else {
                    // num[i]를 더하고 i 한개 넘어가기
                    result += nums[i];
                    i--;
                }
                // i-1이 0보다 작으면
            } else {
                // num[i]를 더하고 i 한개 넘어가기
                result += nums[i];
                i--;
            }
        }

        int lastIndex = i;
        i = 0;
        while (lastIndex >= i) {
            if (lastIndex >= i + 1) {
                // 결과에 두수의 곱을 더하고, i 두개 넘어가기
                result += nums[i] * nums[i + 1];
                i += 2;
            }
            // i-1이 0보다 작으면
            else {
                // num[i]를 더하고 i 한개 넘어가기
                result += nums[i];
                i++;
            }
        }

        System.out.println(result);
    }
}