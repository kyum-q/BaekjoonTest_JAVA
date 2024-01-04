import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int pre = Integer.parseInt(st.nextToken());
            int result = Integer.parseInt(st.nextToken());

            bw.write(BFS(pre, result) + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static String BFS(int value, int result) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<String> commands = new LinkedList<>();

        boolean [] visit = new boolean[10001];

        String command = "";

        visit[value] = true;
        queue.add(value);
        commands.add(command);

        while (!queue.isEmpty()) {
            value = queue.poll();
            command = commands.poll();

            if (value == result)
                break;

            // D
            int newValue = value * 2 % 10000;
            if(!visit[newValue]) {
                visit[newValue] = true;
                queue.add(newValue);
                commands.add(command + 'D');
            }

            // S
            newValue = (value+9999) % 10000;
            if(!visit[newValue]) {
                visit[newValue] = true;
                queue.add(newValue);
                commands.add(command + 'S');
            }

            // L
            newValue = (value*10)%10000 + (value/1000);
            if(!visit[newValue]) {
                visit[newValue] = true;
                queue.add(newValue);
                commands.add(command + 'L');
            }

            // R
            newValue = (value%10)*1000 + value/10;
            if(!visit[newValue]) {
                visit[newValue] = true;
                queue.add(newValue);
                commands.add(command + 'R');
            }
        }

        return command;
    }
}
