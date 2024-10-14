import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        for (int i = 0; i < 10; i++) {
            int value = Integer.parseInt(br.readLine());
            if(Math.abs(100 - result - value) <= Math.abs(100 - result)) {
                result += value;
            }
            else {
                break;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
