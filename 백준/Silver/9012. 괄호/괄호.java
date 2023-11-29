import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int openSize = 0;
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '(')
                    openSize++;
                else if(s.charAt(j) == ')')
                    openSize--;

                if(openSize < 0) {
                    break;
                }
            }

            if(openSize == 0)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }

        bw.flush();
        bw.close();
    }

}