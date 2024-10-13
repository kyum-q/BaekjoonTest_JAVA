import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Set<Integer> people = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(br.readLine());
            people.add(key);
        }

        int result = 0;
        for (int i = 1; i <= C; i++) {
            for (Integer person : people) {
                if(i % person == 0) {
                    result++;
                    break;
                }
            }
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
