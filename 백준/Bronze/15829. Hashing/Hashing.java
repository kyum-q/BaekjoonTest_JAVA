import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int r = 31;
        int m = 1234567891;
        long h = 0;
        long pow = 1;
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            h = h + (s.charAt(i)-'a'+1) * pow % m;
            pow = pow * r % m;

        }

        System.out.println(h % m);
    }
}