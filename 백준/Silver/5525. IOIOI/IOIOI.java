import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        char [] s = br.readLine().toCharArray();
        
        int result = 0;
        int count = 0;
        for (int i = 1; i < M-1; i++) {
            if(s[i-1] == 'I' && s[i] == 'O' &&  s[i+1] == 'I') {
                count++;
                if(count == N) {
                    count--;
                    result++;
                }
                i++;
            }
            else {
                count = 0;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}