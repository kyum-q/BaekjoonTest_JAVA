import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] nums = new int[K];
        long sum = 0;
        for (int i = 0; i < K; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        long result = 0;

        long low = 1, high = sum / N;
        while(low <= high) {
            long mid = (high + low) / 2;
            int count = 0;
            for (int j = 0; j < K; j++) {
                count += nums[j] / mid;
            }
            if (count >= N) {
                result = Math.max(result, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
