import java.io.*;
import java.util.*;

class Solution
{
	 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            int N = Integer.parseInt(br.readLine());

            int [] nums = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int n=0;n<N;n++) {
                nums[n] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            long count = 0;
            int max = nums[N-1];
            for(int n=N-2;n>=0;n--) {
                if(max < nums[n]) {
                    result = result + count * max;
                    count = 0;
                    max = nums[n];
                }
                else {
                    count++;
                    result -= nums[n];
                }
            }
            result = result + count * max;

            bw.write("#"+t+" "+result+"\n");
        }

        bw.flush();
        bw.close();
    }

}
