
import java.util.*;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String Nnum = sc.next();
		char [] num = Nnum.toCharArray();
		int sum =0;
		for(int i=0;i<N;i++) {
			sum += num[i] - '0';
		}
		System.out.println(sum);
	}
}
