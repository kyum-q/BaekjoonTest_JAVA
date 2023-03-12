import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// N 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		// 입력받을 배열
		int num [] = new int[N];
		
		// 배열 입력 
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 배열 정렬
		Arrays.sort(num);
		
		// 출력
		for(int i=0;i<N;i++)
			bw.write(num[i]+"\n");
		
		bw.flush();
		bw.close();
	}
}