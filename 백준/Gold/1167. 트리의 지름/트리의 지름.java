import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int maxDistance = 0;
    public static int maxNodeLastIndex = 0;
    public static boolean [] isChecked;

    public static ArrayList<Node>[] lists;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // V 입력
        int V = Integer.parseInt(br.readLine());

        // 큐 및 체크 리스트 생성
        lists = new ArrayList[V];
        isChecked = new boolean[V];

        // 각 V에 연결된 정보 입력
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;

            // 큐 생성
            lists[index] = new ArrayList<>();

            // 연결된 정점 추가
            int count = st.countTokens();
            for (int j = 0; j < count - 1; j = j + 2) {
                int peek = Integer.parseInt(st.nextToken()) - 1;
                int distance = Integer.parseInt(st.nextToken());

                lists[index].add(new Node(peek, distance));
            }
        }

        // 아무 노드나 시작 노드로 설정해서 DFS
        int newDistance = DFS(0, 0);
        maxDistance = Math.max(maxDistance, newDistance);

        // 가장 컸던 노드를 설정해서 DFS
        newDistance = DFS(maxNodeLastIndex, 0);
        maxDistance = Math.max(maxDistance, newDistance);
        System.out.println(maxDistance);

    }

    public static int DFS(int index, int distance) {
        isChecked[index] = true;

        int max = distance;
        for (int i = 0; i < lists[index].size(); i++) {
            Node node = lists[index].get(i);

            if(!isChecked[node.peak]) {
                maxDistance = Math.max(maxDistance, distance + node.distance);
                int newDistance = DFS(node.peak, distance + node.distance);
                max = Math.max(max, newDistance);
            }
        }

        isChecked[index] = false;

        if(max == distance && maxDistance == max) {
            maxNodeLastIndex = index;
        }

        return max;
    }

    public static class Node {
        public int peak;
        public int distance;
        public Node(int peek, int distance) {
            this.peak = peek;
            this.distance = distance;
        }
    }
}