import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 입력
        int N = Integer.parseInt(br.readLine());

        // 공백 없이 숫자 입력
        String nums = br.readLine();

        // 합하기
        int sum = 0;
        for(int i=0;i<N;i++){
            sum += Integer.parseInt(String.valueOf(nums.charAt(i)));
        }

        // 합 출력
        System.out.println(sum);
    }
}