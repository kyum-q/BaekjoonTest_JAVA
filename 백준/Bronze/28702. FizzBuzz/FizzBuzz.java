import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = 0;
        for (int i = 0; i < 3; i++) {
            String fizz = br.readLine();
            if (!fizz.contains("Fizz") && !fizz.contains("Buzz")) {
                num = Integer.parseInt(fizz) + (3 - i);
                break;
            }
        }

        if (num % 3 != 0 && num % 5 != 0) {
            bw.write(String.valueOf(num));
        } else {
            String result = "";
            if (num % 3 == 0) {
                result += "Fizz";
            }
            if (num % 5 == 0) {
                result += "Buzz";
            }
            bw.write(result);
        }
        bw.flush();
        bw.close();
    }
}
