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
		int target_index = (int) (N-1);
		long target = num[(int)(target_index)];
		long start = 0;
		long end = N-1;
		long count = 0;
		long sum =  num[(int)start]+num[(int)end];
		while(target_index >= 0) {
				
			sum = num[(int)start]+num[(int)end];
            
			// target == num[start]+num[end] --> count++
            
            if(start>=end){
                target_index--;
                if(target_index == -1)
					break;
				target = num[(int)(target_index)];
				start = 0;
                end = N-1;
                sum =  0;
            }
            
			else if(target == sum) {
				if(start==target_index)
					start++;
				else if(end == target_index)
					end--;
				else {
					count++;
					target_index--;
					if(target_index == -1)
						break;
				    target = num[(int)(target_index)];
				    start = 0;
                    end = N-1;
                    sum =  0;
				}
			}
			
			// target > num[start]+num[end]
			else if(target > sum) {
				start++;
			}
            // target < num[start]+num[end]
            else {
                end--;
            }
		}
		
		System.out.println(count);
	}
}
