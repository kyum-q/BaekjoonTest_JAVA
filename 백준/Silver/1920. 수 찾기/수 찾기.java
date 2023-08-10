import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // N개의 A 입력
        int A [] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // A 정렬
        Arrays.sort(A);

        // M 입력
        int M = Integer.parseInt(br.readLine());

        // M개의 수 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            int num = Integer.parseInt(st.nextToken());

            // 이진탐색에 필요한 변수
            int pivot = N/2;
            int start = 0;
            int end = N;

            // 해당 변수가 존재하는지 확인하는 변수 (존재 할 경우 1, 아닐 경우 0)
            int isContain = 0;

            // num이 A 배열에 존재하는지 이진탐색으로 확인

            // 시작, 끝의 차이가 1보다 작아질 때까지 반복
            while(end - start > 1) {
                // 현재 index의 값이 num과 동일할 경우
                if(A[pivot] == num) {
                    isContain = 1;
                    break;
                }
                // 현재 index의 값이 num보다 클 경우
                else if(A[pivot] > num) {
                    end = pivot;
                }
                // 현재 index의 값이 num보다 작을 경우
                else {
                    start = pivot;
                }

                // 중앙 값 설정
                pivot = start + (end-start)/2;
            }

            // 해당 값이 num인지 확인
            if(A[pivot] == num) {
                isContain = 1;
            }

            System.out.println(isContain);
        }

    }
}