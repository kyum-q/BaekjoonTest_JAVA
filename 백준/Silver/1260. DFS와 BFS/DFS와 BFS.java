import java.io.*;
import java.util.*;

public class Main {
    static ArrayList[] list;
    static boolean[] isChecked;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N,M,V 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken()) - 1;

        // 확인여부 list | 인접노드를 알려줄 list 생성
        isChecked = new boolean[N];

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            list[s].add(e);
            list[e].add(s);
        }

        // 인접노드 오름차순 정렬
        for (int i = 0; i < N; i++) {
            Collections.sort(list[i]);
        }

        // DFS 확인
        DFS(V);
        bw.write("\n");

        // 체크했는지 여부 리스트 초기화
        isChecked = new boolean[N];

        // BFS 확인
        BFS(V);
        bw.write("\n");

        // 출력
        bw.flush();
        bw.close();
    }

    public static void DFS(int start) throws IOException {
        if (isChecked[start]) return;

        // 출력
        bw.write(start + 1 + " ");

        // 체크했음을 기록
        isChecked[start] = true;

        // 인접 노드 확인
        for (int i = 0; i < list[start].size(); i++) {
            DFS((Integer) list[start].get(i));
        }
    }

    public static void BFS(int start) throws IOException {
        Queue<Integer> queue = new LinkedList();

        int index = start;
        queue.add(index);
        isChecked[index] = true;

        while (!queue.isEmpty()) {

            // 출력
            index = queue.poll();
            bw.write(index + 1 + " ");

            // 인접 노드 확인
            for (int i = 0; i < list[index].size(); i++) {
                int newIndex = (Integer) list[index].get(i);
                
                // 확인한 노드가 아니면 queue에 삽입 후 확인했음을 기록
                if (!isChecked[newIndex]) {
                    queue.add(newIndex);
                    isChecked[newIndex] = true;
                }
            }
        }
    }
}