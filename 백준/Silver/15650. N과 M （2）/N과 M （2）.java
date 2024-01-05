import java.io.*;
import java.util.*;

public class Main {
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        combination(1, new boolean[N+1], 0, N, M);
        
        bw.flush();
        bw.close();
    }

    public static void combination(int value, boolean [] visit, int depth, int N, int M) throws IOException {
        if(depth == M) {
            for (int i = 1; i <= N; i++) {
                if(visit[i]) {
                    bw.write(i +" ");
                }
            }
            bw.write("\n");
            return;
        }

        if(value > N)
            return;

        for (int i = value; i <= N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combination(i+1, visit, depth + 1, N, M);
                visit[i] = false;
            }
        }
    }
}
