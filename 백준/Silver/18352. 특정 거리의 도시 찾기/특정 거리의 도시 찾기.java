import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static ArrayList<Integer> [] lists;
    static boolean [] isChecked;
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // N개의 도시 초기화
        lists = new ArrayList [N];
        isChecked = new boolean[N];

        for(int i=0;i<N;i++) {
            lists[i] = new ArrayList<>();
        }

        // M개의 도로 입력
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lists[start-1].add(end-1);
        }

        // bfs 실행
        bfs(X-1);

        bw.flush();
        bw.close();
    }

    public static void bfs(int x) throws IOException {
        Queue<Integer> queue = new LinkedList<>();

        // 시작 인덱스 초기화
        queue.add(x);
        isChecked[x] = true;

        // count 세기
        int count = 0;

        // queue에 담겨진게 없을 때까지
        while(!queue.isEmpty()) {
            // 현재 queue 사이즈만큼 queue에서 index를 알아내, 해당 index와 연결된 도시들을 queue에 추가
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++) {
                ArrayList<Integer> list = lists[queue.poll()];
                for(int j=0;j<list.size();j++) {
                    // 해당 index와 연결된 도시들을 queue에 추가
                    int newIndex = list.get(j);
                    if(!isChecked[newIndex]) {
                        isChecked[newIndex] = true;
                        queue.add(newIndex);
                    }
                }
            }
            // count 증가 후, 비교를 통해 원하는 이동 값과 동일해질 경우 break
            count++;
            if(count == K) {
                break;
            }
        }

        // 만약, count가 동일하고 큐가 비어있지 않으면 해당 값들 출력
        if(count == K && !queue.isEmpty()) {
            int [] outputs = new int[queue.size()];
            for(int i=0;i<outputs.length;i++) {
                outputs[i] = queue.poll();
            }

            // 정렬해서 오름차순으로 출력
            Arrays.sort(outputs);
            for(int i=0;i<outputs.length;i++) {
                bw.write(outputs[i]+1 + "\n");
            }
        }
        // 그렇지 않으면 -1 출력
        else {
            bw.write(-1 + "\n");
        }
    }
}