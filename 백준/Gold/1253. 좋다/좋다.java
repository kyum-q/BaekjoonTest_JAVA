import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long [] num = new long [(int)N];
		for(int i=0;i<N;i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(num);
		
		long count = 0;
		for(int i=0;i<N;i++) {
			long target = num[i];
			long start = 0;
			long end = N-1;
			long sum =  0;
			while(start<end) {
				sum = num[(int)start]+num[(int)end];
				// target == num[start]+num[end] --> count++
				if(target == sum) {
					if(start==i)
						start++;
					else if(end == i)
						end--;
					else {
						count++;
						break;
					}
				}
				else if(target < sum) {
					end--;					
				}

				// target > num[start]+num[end] //if(target > sum)
				else{
					start++;
				}								
			}
		}
		
		System.out.println(count);
	}
}
