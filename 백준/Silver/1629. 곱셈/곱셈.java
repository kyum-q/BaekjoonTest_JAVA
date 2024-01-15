import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long sum = pow(a, b, c) % c;

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }

    public static long pow(int a, int b, int c) {
        if(b == 1)
            return a % c;

        long result = pow(a, b/2, c);
        if(b % 2 == 0) {
            return result * result % c;
        }
        return ((result * result) % c) * a % c;
    }
}