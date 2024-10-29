class Solution {
    private final int[] dx = new int[]{1, -1, 0, 0};
    private final int[] dy = new int[]{0, 0, 1, -1};
    private final boolean[][] visited = new boolean[102][102];
    private final int[][] map = new int[102][102];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 좌표를 2배로 확대
        for (int[] rect : rectangle) {
            for (int i = rect[0] * 2; i <= rect[2] * 2; i++) {
                for (int j = rect[1] * 2; j <= rect[3] * 2; j++) {
                    map[i][j] = 1;
                }
            }
        }

        // 내부를 0으로 채움
        for (int[] rect : rectangle) {
            for (int i = rect[0] * 2 + 1; i < rect[2] * 2; i++) {
                for (int j = rect[1] * 2 + 1; j < rect[3] * 2; j++) {
                    map[i][j] = 0;
                }
            }
        }

        return DFS(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    public int DFS(int characterX, int characterY, int itemX, int itemY) {
        if (characterX == itemX && characterY == itemY) {
            return 0;
        }
        visited[characterX][characterY] = true;

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int newX = characterX + dx[i];
            int newY = characterY + dy[i];
            if (newX < 0 || newY < 0 || newX > 100 || newY > 100 ||
                    visited[newX][newY] || map[newX][newY] != 1) {
                continue;
            }
            int dfs = DFS(newX, newY, itemX, itemY);
            if (dfs != Integer.MAX_VALUE) {
                result = Math.min(result, 1 + dfs);
            }
        }
        return result;
    }
}