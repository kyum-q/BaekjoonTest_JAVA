import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long [][] sumArray = new long[N+1][N+1];
		long num = 0;
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				num = Integer.parseInt(st.nextToken());
				sumArray[i][j]=sumArray[i-1][j]+sumArray[i][j-1]-sumArray[i-1][j-1]+num;
				// sumArray = 내 앞에 있는 sumArray + 내 위에 있는 sumArray - 앞에 두개에서 중복되는 값 + 내 칸 값
				// sumArray = [1][1] ~ [i][j]까지 네모 합
			}
		}
		//sc.nextLine();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = (int)(sumArray[x2][y2] - sumArray[x1-1][y2] - sumArray[x2][y1-1] + sumArray[x1-1][y1-1]);
			// result = [1][1]부터 [x2][y2] - 합의 시작지점까지 불필요한 열 삭제 - 합의 삭제 지점까지 불필요한 행 삭제 + 두번 삭제 된 값
			System.out.println(result);
		}
	}
}
