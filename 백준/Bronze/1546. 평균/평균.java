
import java.util.*;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double [] score = new double [N];
		int max = 0;
		for(int i=0;i<N;i++) {
			score[i] = sc.nextInt();
			if(max<score[i])
				max = (int)score[i];
		}
		double sum =0;
		for(int i=0;i<N;i++) {
			score[i] = score[i]/max * 100;
			sum += score[i];
		}
		double avg = sum/N;
		System.out.println(avg);
	}
}
