import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tShirt = new int[6];
        for (int i = 0; i < 6; i++) {
            tShirt[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int tCount = 0;
        for (int i = 0; i < 6; i++) {
            int plusCount = (tShirt[i] % T == 0) ? 0 : 1;
            tCount += tShirt[i] / T + plusCount;
        }

        bw.write(tCount + "\n");
        bw.write(N / P + " " + N % P + "\n");

        bw.flush();
        bw.close();
    }
}
