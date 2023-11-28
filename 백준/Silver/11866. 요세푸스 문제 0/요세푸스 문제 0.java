import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> lists = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            lists.add(i);
        }

        int index = K-1;
        bw.write("<");
        while(lists.size() > 1) {
            bw.write(lists.get((int) index)+", ");
            lists.remove((int) index);
            index = (index+K-1) % lists.size();
        }

        bw.write(lists.get(0)+">");
        bw.flush();
        bw.close();
    }

}