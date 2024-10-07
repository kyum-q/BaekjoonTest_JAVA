import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[] fruits = new int[N];

        int start = 0;
        int end = 1;

        fruits[0] = Integer.parseInt(st.nextToken());
        map.put(fruits[0], 1);

        int max = 1;
        for (int i = 1; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
            if (map.containsKey(fruits[i])) {
                map.put(fruits[i], map.get(fruits[i]) + 1);
            }
            else {
                map.put(fruits[i], 1);
                while (map.size() > 2) {
                    Integer value = map.get(fruits[start]);
                    if (value == 1) {
                        map.remove(fruits[start]);
                    } else {
                        map.put(fruits[start], value - 1);
                    }
                    start++;
                }
            }
            end++;
            max = Math.max(max, end - start);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
