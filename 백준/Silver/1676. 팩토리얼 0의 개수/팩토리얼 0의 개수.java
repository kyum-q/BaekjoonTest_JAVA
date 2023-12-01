import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 2; i <= N; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String s = String.valueOf(factorial);
        int count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) != '0')
                break;
            count++;
        }

        System.out.println(count);
    }
}