import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                int value = 0;
                if(!queue.isEmpty()) {
                    value = queue.poll();
                }
                bw.write(value + "\n");
            }
            else {
                queue.add(num);
            }
        }

        bw.flush();
        bw.close();
    }
}