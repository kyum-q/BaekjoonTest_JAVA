import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		
		// n개의 수
		int N = sc.nextInt();
		int num [] = new int [N];
		
		// 해당 배열 가능 여부
		boolean stackCheck = true;
		
		// stack
		Stack<Integer> stack = new Stack<Integer>();
		
		// stack 입출력 배열
		ArrayList<String> result = new ArrayList<String>();
		
		// 수열 입력
		for(int i=0;i<N;i++) 
			num[i] = sc.nextInt();
		
		// 현재 스택의 개수
		int stackSum = 0;
		
		for(int i=0;i<N;i++) {
			// 현재 값이 이전 pop된 값보다 클 경우 (data push)
			if(i==0 || num[i]>num[i-1]) {
				// 현재 값(num[i]) 만큼 스택에 +num (push) and -1 pop
				for(int s=stackSum+1;s<=num[i];s++) {
					stackSum++;
					stack.push(s);
					result.add("+\n");
				}
				stack.pop();
				result.add("-\n");
			}
			// 현재 값이 이전 pop된 값보다 작을 경우 (data pop)
			else {
				int pop = stack.pop();
				result.add("-\n");
				
				// 현재 top에 있는 수가 현재 값보다 클 경우
				if(pop > num[i]) {
					stackCheck = false;
					break;
				}
			}
		}
		if(stackCheck)	{
			for(int i=0;i<N*2;i++)
				System.out.print(result.get(i));
		}
		else
			System.out.print("NO");
	}
}