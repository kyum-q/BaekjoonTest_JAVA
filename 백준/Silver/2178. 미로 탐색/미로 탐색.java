import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> [][] list;
    static boolean[][] isChecked;

    static int N, M, count = 0;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N,M,V 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 확인여부 list | 인접노드를 알려줄 list 생성
        isChecked = new boolean[N][M];

        list = new ArrayList[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                list[i][j] = new ArrayList();
            }
        }

        // 간선 입력 (갈 수 있는 방향 추가 : 0 = 오른쪽 | 1 = 아래 | 2 = 위 | 3 = 왼쪽 )
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);

                // 해당 값이 1일 경우 주변에서 여기로 올 수 있는 것이므로 주변에 간선으로 추가
                // (갈 수 있는 방향 추가 : 0 = 오른쪽 | 1 = 아래 | 2 = 위 | 3 = 왼쪽 )
                if(c == '1') {
                    if(j+1 < M) list[i][j+1].add(0);
                    if(i+1 < N) list[i+1][j].add(1);
                    if(i-1 >= 0) list[i-1][j].add(2);
                    if(j-1 >= 0) list[i][j-1].add(3);
                }
            }
        }

        // BFS 확인
        BFS(new Node(0,0));

        bw.write(count + "");
        // 출력
        bw.flush();
        bw.close();
    }

    public static void BFS(Node node) {
        // 시작 노드 추가
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        isChecked[node.x][node.y] = true;

        // 다음 queue가 없을 때까지
        while (!queue.isEmpty()) {
            count++;

            // 이번 count 인접 노드 다 확인
            int queueSize = queue.size();
            for(int k = 0; k<queueSize; k++) {
                node = queue.poll();

                // 종료 노드에 도착했을 경우 끝내기
                if (node.x == N - 1 && node.y == M - 1) {
                    return;
                }

                // 인접 노드 확인
                for (int i = 0; i < list[node.x][node.y].size(); i++) {
                    int gotoWhere = list[node.x][node.y].get(i);

                    // 확인한 노드가 아니면 queue에 삽입 후 확인했음을 기록
                    switch (gotoWhere) {
                        case 0:
                            if (!isChecked[node.x][node.y - 1]) {
                                isChecked[node.x][node.y - 1] = true;
                                queue.add(new Node(node.x, node.y - 1));
                            }
                            break;
                        case 1:
                            if (!isChecked[node.x - 1][node.y]) {
                                isChecked[node.x - 1][node.y] = true;
                                queue.add(new Node(node.x - 1, node.y));
                            }
                            break;
                        case 2:
                            if (!isChecked[node.x + 1][node.y]) {
                                isChecked[node.x + 1][node.y] = true;
                                queue.add(new Node(node.x + 1, node.y));
                            }
                            break;
                        case 3:
                            if (!isChecked[node.x][node.y + 1]) {
                                isChecked[node.x][node.y + 1] = true;
                                queue.add(new Node(node.x, node.y + 1));
                            }
                            break;
                    }
                }
            }
        }
    }

    static class Node {
        public int x;
        public int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}