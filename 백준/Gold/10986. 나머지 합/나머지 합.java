
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
	(s2-s1)%3 == 0 : 우리가 구하려고 한 값 (구간의 합의 나머지가 0)
	s2%3 - s1%3 == 0
	s2%3 == s1%3
	
	=> 즉 나머지가 같은 합들(k)을 찾아 이들 중 2가지를 뽑으면 됌 (kC2)
**/

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N, M;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		long [] sumNum = new long [N+1];
		long count = 0;
		long remainderCount[] = new long[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {	// 수 입력 받아서 0부터 i까지 합 구하기
			sumNum[i+1] = sumNum[i]+Long.parseLong(st.nextToken());
		}

		for(int i=0;i<N;i++) {	// 0부터 i까지 합을 M으로 나누어 나머지 구하기
			sumNum[i+1] %= M;
			
			if(sumNum[i+1] == 0) { // 나눈 값이 0일 때 count++ (0부터 i까지도 나머지가 0인거니까)
				count ++;
			}
			remainderCount[(int) sumNum[i+1]]++;	// 나머지 배열에 해당 나머지 index ++;
		}
		
		for(int i=0;i<M;i++) {	// 나머지 배열을 가지고 나누어 떨어지는 구간 합 구하기
			// (kC2) => (k)*(k-1)/2
			count = count + remainderCount[i]*(remainderCount[i] - 1)/2;
		}

		System.out.println(count);
	}
}
