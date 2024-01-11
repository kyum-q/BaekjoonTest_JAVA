import java.io.*;
import java.util.*;

public class Main {
    public static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        set = new LinkedHashSet<>();

        int [] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        combination(nums, new int[M], 0, 0, N, M);

        for(String s : set) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void combination(int [] nums, int [] arr, int start, int depth, int N, int M) {
        if (depth == M) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < M; i++) {
                s.append(arr[i]).append(" ");
            }
            set.add(s.toString());
            return;
        }

        for (int i = start; i < N; i++) {
                arr[depth] = nums[i];
                combination(nums, arr, i, depth + 1, N, M);
        }
    }
}
