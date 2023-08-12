import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> nums = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);

        // M, N 입력
        int M = sc.nextInt();
        int N = sc.nextInt();

        // M 이상 N 이하 배열 제작
        for(int i=M;i<=N;i++){
            nums.add(i);
        }

        // 2부터 N까지 확인
        for(int i=2;i<=N;i++){
            // 만약 i가 M보다 큰데, 해당 값이 0이 아닐 때 출력 ( 0이면 소수가 아니라 제거된 값 )
            if(i >= M) {
                if (nums.get(i - M) != 0) {
                    bw.write(nums.get(i - M) + "\n");
                    // i부터 N까지 확인
                    distinction(i, M, N);
                }
            }
            else {
                distinction(i, M, N);
            }
        }

        bw.flush();
        bw.close();
    }

    public static void distinction(int i, int start, int end) {
        int mult = 1;
        for (int j = i; j <= end; mult++, j = i*mult) {
            // 만약 j가 M보다 큰데, 해당 값이 i로 나누어 떨어질때 해당 값 소수에서 제거
            if (j >= start && nums.get(j - start) % i == 0) {
                nums.set(j - start, 0);
            }
        }
    }
}