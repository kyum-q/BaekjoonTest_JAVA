import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [][] nums = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] sums = new int[N][N];
        sums[0][0] = nums[0][0];
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < i+1; j++) {
                sums[i+1][j] = Math.max(sums[i][j] + nums[i+1][j], sums[i+1][j]);
                sums[i+1][j+1] = Math.max(sums[i][j] + nums[i+1][j+1], sums[i+1][j+1]);

            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, sums[N-1][i]);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

}