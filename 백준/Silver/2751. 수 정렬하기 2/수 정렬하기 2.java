import java.io.*;
import java.util.Arrays;

public class Main {
    public static int [] nums, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 수 입력
        nums = new int [N];
        temp = new int [N];

        for(int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 수 정렬하기
//        Arrays.sort(nums);

        // 합병 정렬로 정렬하기
        mergeSort(0, N-1);

        for(int i=0;i<N;i++) {
            bw.write(nums[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void mergeSort(int s, int e) {
        if(e - s < 1) {
            return;
        }

        // 분할
        int m = s + (e-s) / 2;
        mergeSort(s, m);
        mergeSort(m+1, e);

        // s~e까지 temp 복사
        for(int i=s;i<=e;i++) {
            temp[i] = nums[i];
        }

        // 변수 초기화
        int originalIndex = s;
        int index1 = s;
        int index2 = m+1;

        // 병합
        while(index1 <= m && index2 <= e) {
            if(temp[index1] < temp[index2]) {
                nums[originalIndex] = temp[index1];
                index1++;
            }
            else {
                nums[originalIndex] = temp[index2];
                index2++;
            }
            originalIndex++;
        }

        while(index1 <= m) {
            nums[originalIndex] = temp[index1];
            index1++;
            originalIndex++;
        }
        while(index2 <= e) {
            nums[originalIndex] = temp[index2];
            index2++;
            originalIndex++;
        }
    }
}
