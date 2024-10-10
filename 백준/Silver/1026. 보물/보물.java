import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> firstNums = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            firstNums.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> secondNums = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            secondNums.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(firstNums);
        Collections.sort(secondNums, Comparator.reverseOrder());

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += firstNums.get(i) * secondNums.get(i);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
