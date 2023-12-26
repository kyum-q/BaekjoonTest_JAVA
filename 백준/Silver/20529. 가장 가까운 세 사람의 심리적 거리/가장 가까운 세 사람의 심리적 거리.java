import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<char []> mbti = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                mbti.add(st.nextToken().toCharArray());
            }

            int min = 100001;

            if(N >= 33)
                min = 0;

            for (int i = 0; i < N-2; i++) {
                if(min == 0) break;
                for (int j = i+1; j < N-1; j++) {
                    for (int l = j+1; l < N; l++) {
                        int sum = 0;

                        char [] mbti1 = mbti.get(i);
                        char [] mbti2 = mbti.get(j);
                        char [] mbti3 = mbti.get(l);
                        for (int k = 0; k < 4; k++) {
                            if(mbti1[k] != mbti2[k])
                                sum++;
                            if(mbti1[k] != mbti3[k])
                                sum++;
                            if(mbti2[k] != mbti3[k])
                                sum++;
                        }
                        min = Math.min(min, sum);
                    }
                }
            }

            bw.write(min + "\n");
        }

        bw.flush();
        bw.close();
    }
}