import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int t = 0; t < N; t++) {
            nums[t] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = i+1; j < N-1; j++) {
                for (int k = j+1; k < N; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum <= M && result < sum) {
                        result = sum;
                    }
                }
            }
        }

        System.out.println(result);
    }
}