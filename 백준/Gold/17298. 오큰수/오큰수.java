import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N입력
		int N = Integer.parseInt(st.nextToken());
		
		// N개의 수 num[] 입력
		Stack<Integer> stack = new Stack<Integer>();
		
		// 입력 수열 배열, 결과 배열
		int num [] = new int [N];
		int result [] = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(st.nextToken());
			// 만약 현재 값이 스택 top에 들어있는 값보다 더 큰 경우 -> 현재 값이 top의 오큰수 (반복)
			while(!stack.isEmpty() && num[stack.peek()] < n) {
				result[stack.pop()] = n;
			}
			stack.push(i);
			num[i] = n;
		}
		
		// 전체를 다 확인했는데도 stack에 값이 남아있는 경우 -> 오큰 수가 없는 경우
		while(!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		
		for(int i=0;i<N;i++)
			bw.write(result[i]+" ");
		
		bw.flush();
		bw.close();
	}
}