import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());

            String s = br.readLine();
            Deque<Integer> nums = new LinkedList<>();

            if(s.length() > 2) {
                s = s.substring(1, s.length() - 1);
                String[] split = s.split(",");

                for (int i = 0; i < N; i++) {
                    nums.add(Integer.parseInt(split[i]));
                }
            }

            boolean popFirst = true;
            boolean isError = false;

            for (int i = 0; i < command.length(); i++) {
                char value = command.charAt(i);

                if (value == 'R') {
                    popFirst = !popFirst;
                } else if (value == 'D') {
                    if (nums.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (popFirst) {
                        nums.pollFirst();
                    } else {
                        nums.pollLast();
                    }
                }
            }
            if (isError) {
                bw.write("error\n");
            } else {
                bw.write("[");
                if(popFirst) {
                    for (int j = nums.size()-1; j > 0; j--) {
                        bw.write(nums.pollFirst() + ",");
                    }
                    if(!nums.isEmpty())
                        bw.write(nums.pollFirst().toString());
                }
                else {
                    for (int j = nums.size()-1; j > 0; j--) {
                        bw.write(nums.pollLast() + ",");
                    }
                    if(!nums.isEmpty())
                        bw.write(nums.pollLast().toString());
                }
                bw.write("]\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
