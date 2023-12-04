import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nonEyes = new HashMap<>();
        for (int i = 0; i < N; i++) {
            nonEyes.put(br.readLine(), i);
        }

        ArrayList<String> nonEyesNonListen = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String nonListen = br.readLine();
            if(nonEyes.get(nonListen) != null) {
                nonEyesNonListen.add(nonListen);
            }
        }

        Collections.sort(nonEyesNonListen);

        bw.write(nonEyesNonListen.size() + "\n");
        for (int i = 0; i < nonEyesNonListen.size(); i++) {
            bw.write(nonEyesNonListen.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }

}