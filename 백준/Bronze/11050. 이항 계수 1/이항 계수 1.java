import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(binomial(a,b));
    }

    public static int binomial(int a, int b) {
        int aSum = a;
        int bSum = b;
        for (int i = 1; i < b; i++) {
            aSum *= (a-i);
            bSum *= (b-i);
        }

        if(bSum == 0) return 1;
        return aSum / bSum;
    }
}