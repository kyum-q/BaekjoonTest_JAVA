import java.io.*;
import java.util.*;

public class Main {
    public static int N,r,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);

        bw.write(find(size, r, c) + "\n");

        bw.flush();
        bw.close();
    }

    public static int find(int size, int r, int c) {
        if(size == 1) return 0;

        // 1사분면
        if(r < size/2 && c < size/2) {
            return find(size/2, r, c);
        }
        // 2사분면
        if(r < size/2 && c >= size/2) {
            return find(size/2, r, c-size/2) + (size * size / 4);
        }
        // 3사분면
        if(r >= size/2 && c < size/2) {
            return find(size/2, r-size/2, c) + (size * size / 4 * 2);
        }
        // 4사분면
        return find(size/2, r-size/2, c-size/2) + (size * size / 4 * 3);
    }
}