import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(treeMap.containsKey(num)) {
                treeMap.put(num, treeMap.get(num)+1);
            }
            else {
                treeMap.put(num, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(treeMap.containsKey(num)){
                bw.write(treeMap.get(num) + " ");
            }
            else {
                bw.write("0 ");
            }
        }
        bw.flush();
        bw.close();
    }
}