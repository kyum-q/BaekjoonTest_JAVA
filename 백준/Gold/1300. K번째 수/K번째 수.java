import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // k 입력
        int k = Integer.parseInt(br.readLine());

        // 이진 탐색 변수
        int start = 1;
        int end = k;

        // k값보다 큰 값은 i번째 행의 k/i개의 수가 존재한다는 개념이 중요
        // 최소 값이 최대 값보다 커질 때까지
        while(start <= end) {
            // 중앙 점
            int mid = (start + end) /2;
            
            // 현재 중앙 점 
            int count = 0;
            for(int i=1;i<=N;i++){
                // mid/i랑 N중에 작은 값으로 count 증가
                count += Math.min(mid/i, N);
            }
            // count가 k보다 클경우 end 축소
            if(count >= k)
                end = mid-1;
            // count가 k보다 작을경우 end 확대
            else
                start = mid+1;
        }

        System.out.println(start);
    }
}