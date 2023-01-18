import java.util.Scanner;

// 구간 합 구하기
public class Main {
	public static void main(String [] args) {
		Scanner scn = new Scanner(System.in);
		
		int N, M;
		N = scn.nextInt();
		M = scn.nextInt();
		
		int num[] = new int [N];
		
		// 0부터 N까지 합을 저장하는 배열 
		// sum[n+1] = num[0]부터 num[n]까지 합
		int sum[] = new int [N+1];	
		// sum[0] = 0으로 초기화
		sum[0] = 0;
		for(int i=0;i<N;i++) {
			num[i] = scn.nextInt();

			sum[i+1] = sum[i] + num[i];
		}
		
		for(int i=0;i<M;i++) {
			int start, end;
			// 구하고자하는 구간 입력
			start = scn.nextInt();
			end = scn.nextInt();
			
			// 구간 합 구하기
			System.out.println(sum[end] - sum[start-1]);
		}
	}
}
