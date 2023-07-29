import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수 입력
        String s = br.readLine();
        int [] nums = new int [s.length()];
        for(int i=0;i<s.length();i++) {
            nums[i] = s.charAt(i);
        }

        // 수 정렬
        for(int i=0;i<s.length();i++) {
            // i 이후부터 가장 큰 수 찾기
            int max = i;
            for(int j=i;j<s.length();j++) {
                if(nums[max] < nums[j]) {
                    max = j;
                }
            }

            // 가장 큰 수와 i번째 수와 바꾸기
            int temp = nums[i];
            nums[i] = nums[max];
            nums[max] = temp;

            // 출력
            bw.write(nums[i]);
        }
        bw.flush();
        bw.close();
    }
}
