import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int r = 31;
        int m = 1234567891;
        long h = 0;
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            h += (s.charAt(i)-'a'+1) * Math.pow(r, i);
        }

        System.out.println(h % m);
    }
}