import java.awt.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    int[][] maps;
    int width, height;
    boolean isFinished = false;
    boolean[][] visited;
    int[][] dics;

    public int solution(int[][] maps) {
        this.maps = maps;
        width = maps.length;
        height = maps[0].length;
        visited = new boolean[width][height];
        dics = new int[width][height];

        BFS();

        if (isFinished) return dics[width - 1][height - 1] + 1;
        else return -1;
    }

    public void BFS() {
        // 우선순위 큐를 사용하여 가장 짧은 경로를 먼저 탐색
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        // 상하좌우 이동 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node point = queue.poll();
            int x = point.x;
            int y = point.y;

            // 목적지에 도착하면 isFinished를 true로 설정하고 종료
            if (x == width - 1 && y == height - 1) {
                isFinished = true;
                break;
            }

            // 이웃 셀 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효한 범위 내에 있고, 방문하지 않았으며, 벽이 아닌 경우
                if (isValid(nx, ny) && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                    dics[nx][ny] = dics[x][y] + 1;
                }
            }
        }
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public static class Node {
        public int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
