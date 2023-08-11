import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int start = 0;
        int end = 0;

        // N개의 A 입력
        int A[] = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            
            // 현재 블루레이의 최댓 값을 start로, 전체 합을 end로
            start = Math.max(start, A[i]);
            end += A[i];
        }

        // M개의 블루레이로 나눌때 최소 블루레이 값을 아아내기 위한 반복문
        
        // 블루레이 가능 시작 값(최소)이 끝 값(최대)보다 커질 때 까지
        while (start <= end) {
            // 중앙 값 알아내기
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            // 전체 배열을 확인하면서 배열 합이 중앙값보다 크면 count 증가 및 초기화
            for(int i=0;i<N;i++) {
                if(sum + A[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }
            // sum이 0이 아니면 count 추가
            if(sum != 0)
                count++;
            
            // count가 M보다 크면, M개의 블루레이로 불가능 한 것이므로 최소 값 증가
            if(count > M) 
                start = mid + 1;
            // count가 M보다 작으면, M개의 블루레이로 가능 한 것이므로 최대 값 증가
            else 
                end = mid -1;
        }
        System.out.println(start);
    }
}