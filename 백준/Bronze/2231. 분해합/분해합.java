import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num = 0;
        for (int i = 1; i <= N; i++) {
            String s = String.valueOf(i);
            int sum = i;
            for (int j = 0; j < s.length(); j++) {
                sum += (s.charAt(j) - '0');
            }
            if(sum == N) {
                num = i;
                break;
            }
        }

        System.out.println(num);
    }
}