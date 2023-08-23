import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> [] lists;
    static boolean [] isChecked;
    static int [] counts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N,M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열 초기화
        isChecked = new boolean[N];
        counts = new int[N];
        lists = new ArrayList[N];
        for(int i=0;i<N;i++) {
            lists[i] = new ArrayList<>();
        }

        // M개의 컴퓨터 관계 입력
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a-1].add(b-1);
        }

        // i를 해킹 했을 때, 해킹 가능한 컴퓨터 수 알아내기

        int max = 0;
        for(int i=0;i<N;i++) {
            isChecked = new boolean[N];
            bfs(i);
        }

        for(int i=0;i<N;i++) {
            max = Math.max(max, counts[i]);
        }


        // 가장 많이 해킹할 수 있는 컴퓨터 개수가 max 인 것들의 index를 출력
        for(int i=0;i<N;i++) {
            if(counts[i] == max)
                bw.write(i+1 + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        isChecked[index] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i : lists[now]) {
                if(isChecked[i] == false) {
                    isChecked[i] = true;
                    counts[i]++;
                    queue.add(i);
                }
            }
        }
    }
}