import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 각 인접 리스트 저장할 큐
        Queue<Integer> [] queues = new Queue[N];

        boolean [] isCheck = new boolean[N];

        for(int i=0;i<N;i++) {
            queues[i] = new LinkedList<>();
            isCheck[i] = false;
        }

        // 수 입력
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            queues[u-1].add(v-1);
            queues[v-1].add(u-1);
        }


        Queue<Integer> result = new LinkedList<>();

        int i;

        int count = 0;

        boolean isClear = false;

        while(!isClear) {
            if (!result.isEmpty()) {
                i = result.poll();
            } else {
                i = 0;
                count++;
                while (isCheck[i]) {
                    i++;
                    if (i == N) {
                        isClear = true;
                        break;
                    }
                }
            }
            if (!isClear) {
                isCheck[i] = true;
                int preIndex = i;
                while (!queues[preIndex].isEmpty()) {
                    i = queues[preIndex].poll();
                    if (!isCheck[i]) {
                        result.add(i);
                        isCheck[i] = true;
                    }
                }
            }
        }

        // 출력
        System.out.println(count-1);
    }
}