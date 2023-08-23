import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> [] lists;
    static boolean [] isChecked;
    static int [] bipartiteGraph;
    static boolean isBipartiteGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // K 입력
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            // 정점 개수(V), 간선 개수(E) 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 변수 초기화
            isBipartiteGraph = true;
            lists = new ArrayList[V];
            isChecked = new boolean[V];
            bipartiteGraph = new int[V];

            for(int j=0;j<V;j++) {
                lists[j] = new ArrayList<>();
            }

            // 간선 입력
            for(int j=0;j<E;j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken())-1;
                int e = Integer.parseInt(st.nextToken())-1;

                lists[s].add(e);
                lists[e].add(s);
            }

            // bfs 실행
            for(int j=0;j<V;j++) {
                if(!isChecked[j])
                    bfs(j);
                if(!isBipartiteGraph)
                    break;
            }

            if(isBipartiteGraph)
                bw.write("YES\n");
            else
                bw.write("NO \n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs (int index) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(index);
        bipartiteGraph[index] = 0;
        isChecked[index] = true;

        while(!queue.isEmpty() && isBipartiteGraph) {
            int now = queue.poll();
            for(int i=0;i<lists[now].size();i++) {
                int newIndex = lists[now].get(i);
                if(!isChecked[newIndex]) {
                    bipartiteGraph[newIndex] = (bipartiteGraph[now] + 1) % 2;
                    for(int j=0;j<lists[newIndex].size();j++) {
                        int check = lists[newIndex].get(j);
                        if(isChecked[check] && bipartiteGraph[check] == bipartiteGraph[newIndex] )
                            isBipartiteGraph = false;
                    }

                    isChecked[newIndex] = true;
                    queue.add(newIndex);
                }
            }
        }
    }
}