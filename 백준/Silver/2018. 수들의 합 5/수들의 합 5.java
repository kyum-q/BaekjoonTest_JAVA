import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		int count = 0;
		int start = 1, end = start+1, sum = start;
		
		while(start != N) {	// start가 N과 동일하지 않을 때까지 (합이 N인걸 구하는 거니 이를 지나고 나서는 0임)
			if(end == N || sum >= N) {	// loop 종료(end가 끝까지 가거나 sum이 N이랑 같거나 커졌을 때)
				if(sum == N) // sum이 N일 때 (count 증가)
					count++;
				
				// 초기 설정(start 증가, end/sum 초기화)
				start++;
				end = start + 1;
				sum = start;
				continue;
			}
			sum += end;
			end++;
		}
		System.out.println(count+1); // N 그 자체를 포함하기 위해 count + 1
	}
}