import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int t = 0; t < N; t++) {
            int num = Integer.parseInt(st.nextToken());
            boolean isCheck = num != 1;
            for (int i = 2; i < num; i++) {
                if(num%i == 0) {
                    isCheck = false;
                    break;
                }
            }

            if(isCheck) count++;
        }

        System.out.println(count);
    }
}