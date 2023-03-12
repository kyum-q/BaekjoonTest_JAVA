import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		// 1~N까지 Queue에 삽입
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) 
			queue.add(i);
		
		// Queue에 하나만 남을 때까지 반복
		while(queue.size() > 1) {
			// 맨위에 있는 수 꺼내기
			queue.poll();
			
			// 맨위에 있는 수 꺼내서 맨뒤에 삽입
			int reInsert = queue.poll();
			queue.add(reInsert);
		}
		
		// 출력
		System.out.println(queue.poll());
	}
}