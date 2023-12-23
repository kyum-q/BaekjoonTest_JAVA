import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String s = br.readLine();

        String checkS = "I";
        for (int i = 0; i < N; i++) {
            checkS += "OI";
        }

        int checkSLen = checkS.length();
        int count = 0;
        for (int i = 0; i <= M-checkSLen; i++) {
            if(s.charAt(i) == 'I' && s.substring(i, i+checkSLen).equals(checkS)) {
                count++;
                i++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}