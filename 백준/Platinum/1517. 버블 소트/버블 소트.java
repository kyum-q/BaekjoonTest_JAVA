import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int [] nums, temp;
    public static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        nums = new int[N];
        temp = new int[N];

        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        margeSort(0, N-1);

        System.out.println(result);
    }

    public static void margeSort(int s, int e) {
        if( e - s < 1) return;

        int m = s + (e-s) / 2;

        // 분할
        margeSort(s, m);
        margeSort(m+1, e);

        // temp 복사
        for(int i=s;i<=e;i++) {
            temp[i] = nums[i];
        }

        int i = s;
        int index1 = s;
        int index2 = m+1;

        // 병합
        while(index1 <= m && index2 <= e) {
            if(temp[index1] > temp[index2]) {
                nums[i] = temp[index2++];
                result += m+1 - index1;
            }
            else {
                nums[i] = temp[index1++];
            }
            i++;
        }

        // index1이 남은 배열이 있을 경우
        while(index1 <= m) {
            nums[i] = temp[index1++];
            i++;
        }

        // index1이 남은 배열이 있을 경우
        while(index2 <= e) {
            nums[i] = temp[index2++];
            i++;
        }
    }
}
