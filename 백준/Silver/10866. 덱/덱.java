import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            String [] s = br.readLine().split(" ");

            switch (s[0]) {
                case "push_front":
                    queue.addFirst(Integer.parseInt(s[1]));
                    break;
                case "push_back":
                    queue.addLast(Integer.parseInt(s[1]));
                    break;
                case "pop_front":
                    if (queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(queue.pollFirst() + "\n");
                    break;
                case "pop_back":
                    if (queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(queue.pollLast() + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write((queue.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    if (queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(queue.peekFirst() + "\n");
                    break;
                case "back":
                    if (queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(queue.peekLast() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}