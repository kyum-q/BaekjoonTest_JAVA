import java.awt.desktop.QuitEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시 개수 N 버스 노선 개수 M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 버스 노선 입력
        ArrayList<Edge> lists = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists.add(new Edge(a, b, c));
        }

        // 1부터 i까지 최소 시간을 기록하는 list
        long [] times = new long[N + 1];

        // 1부터 i까지 가는 노선이 있는지 확인하는 list
        boolean[] visited = new boolean[N + 1];

        // 음수사이클 체크 변수
        boolean minusCircle = false;

        visited[1] = true;

        // 모든 경로 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                    Edge edge = lists.get(j);

                    // 방문한 적 있을 경우 더 작은 값으로
                if(visited[edge.start]) {
                    if (visited[edge.arrival])
                        times[edge.arrival] = Math.min(times[edge.arrival], times[edge.start] + edge.time);
                        // 없을 경우 현재 값으로
                    else
                        times[edge.arrival] = times[edge.start] + edge.time;

                    // 방문 체크
                    visited[edge.arrival] = true;
                }
            }
        }

        for (int j = 0; j < M; j++) {
            Edge edge = lists.get(j);

            // 방문한 적 있을 경우 더 작은 값으로
            if (visited[edge.start]) {
                if (times[edge.arrival] > times[edge.start] + edge.time) {
                    minusCircle = true;
                    break;
                }
            }
        }

        // 답 출력
        // 음수사이클 존재할 경우, -1 출력
        if(minusCircle) {
            bw.write("-1\n");
        }
        // 음수사이클 존재하지 않을 경우
        else {
            for (int i = 2; i < N + 1; i++) {
                // 갈 수 있는 최소 시간 출력
                if (visited[i])
                    bw.write(times[i] + "\n");
                // 갈 수 있는 방안이 없을 경우, -1 출력
                else
                    bw.write("-1\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static class Edge {
        public int start;
        public int arrival;
        public int time;
        public Edge(int start, int arrival, int time) {
            this.start = start;
            this.arrival = arrival;
            this.time = time;
        }
    }
}