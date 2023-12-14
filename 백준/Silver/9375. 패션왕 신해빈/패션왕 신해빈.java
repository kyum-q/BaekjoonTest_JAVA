import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            TreeMap<String, Integer> clothes = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                if(clothes.containsKey(kind)) {
                    clothes.put(kind, clothes.get(kind) + 1);
                }
                else {
                    clothes.put(kind, 1);
                }
            }

            long sum = 1;

            ArrayList<Integer> values = new ArrayList<>(clothes.values());

            for (int i = 0; i < values.size(); i++) {
                sum *= values.get(i) + 1;
            }
            bw.write(sum-1 + "\n");
        }

        bw.flush();
        bw.close();
    }
}