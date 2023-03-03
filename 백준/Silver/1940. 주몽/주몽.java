
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 재료의 개수
		Long num[] = new Long[N];
		
		st = new StringTokenizer(br.readLine());
		Long M = Long.parseLong(st.nextToken()); // 재료 두 개의 합 값
		
		st = new StringTokenizer(br.readLine());
		// 재료 입력
		for(int i=0;i<N;i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		
		int start = 0, end = N-1, count = 0;
		
		// num 정렬시키기
		Arrays.sort(num);
		
		// 정렬된 num배열을 start는 앞부터 end는 뒤부터 검사하면서 M을 충족시키는 두 수를 찾는다
		// while 문 (start가 end보다 커질 때까지)
		while(start < end) {
			if(num[start]+num[end] < M)	{
				start++; // M보다 합이 작은거니 start를 늘려 합이 커지게함	
			}
			else if(num[start]+num[end] > M) {// sum이 더 크면 end를 줄여 합을 작게 함
				end--;
			}
			else { // M과 동일하면 count 증가
				count++;
				start++;
				end--;
			}
		}
		System.out.println(count);
		br.close();
	}
}
