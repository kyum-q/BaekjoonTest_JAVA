import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String [] monsters = new String[N];
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            monsters[i] = br.readLine();
            hashMap.put(monsters[i], i);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            int index;
            try {
                index = Integer.parseInt(s);
            }  catch (IllegalArgumentException e) {
                index = -1;
            }

            if(index == -1) {
                bw.write(hashMap.get(s) + 1 + "\n");
            }
            else {
                bw.write(monsters[index-1] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

}