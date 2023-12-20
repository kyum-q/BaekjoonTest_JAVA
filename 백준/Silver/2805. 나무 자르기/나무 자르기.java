import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Long> trees;
    public static long M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        trees = new ArrayList<>();
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (long i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            trees.add(num);
            max = Math.max(max, num);
        }

        bw.write(getTreeSize(1, max) + "\n");
        bw.flush();
        bw.close();
    }

    public static long getTreeSize(long start, long end) {
        if(start >= end) {
            return start - 1;
        }
        long mid = (end+start)/2;
        long sum = 0;
        for (int i = 0; i < trees.size(); i++) {
            if (mid < trees.get(i)) {
                sum += trees.get(i) - mid;
            }

        }

        if(sum < M) {
            return getTreeSize(start, mid);
        }
        else {
            return getTreeSize(mid+1, end);
        }
    }
}