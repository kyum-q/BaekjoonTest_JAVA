import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] nums = new int[N];
        int [] sort = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sort[i] = nums[i];
        }

        sort = Arrays.stream(sort).distinct().toArray();
        Arrays.sort(sort);

        for (int i = 0; i < N; i++) {
            bw.write(binary(sort, nums[i], 0, sort.length) + " ");
        }

        bw.flush();
        bw.close();
    }

    public static int binary(int [] sort, int value, int start, int end) {
        int index = (start + end)/2;
        if(sort[index] == value) return index;
        if(sort[index] > value)
            return binary(sort, value, start, index-1);
        return binary(sort, value, index+1, end);
    }
}