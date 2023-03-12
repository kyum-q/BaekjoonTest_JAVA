import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		long L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		ArrayDeque<Node> dp = new ArrayDeque<>();
		
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			
			// 덱의 마지막 위치부터 now 보다 큰 값은 제거
			while(!dp.isEmpty() && dp.getLast().value > now )
				dp.removeLast();
			
			// 덱에 now 추가
			dp.addLast(new Node(i,now));
			
			// 덱의 처음 위치부터 l의 범위를 벗어난 값 제거
			while(dp.getFirst().index <= i-L)
				dp.removeFirst();
			
			bw.write((int) dp.getFirst().value+ " ");
		}
		bw.flush();
	}
	static class Node {
		long index, value;
		public Node(long index, long value) {
			this.index = index;
			this.value = value;
		}
	}
}


