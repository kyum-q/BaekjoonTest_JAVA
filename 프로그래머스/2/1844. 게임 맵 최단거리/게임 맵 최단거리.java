import java.util.*;

class Solution {
    
    private int maxRow;
    private int maxCol;
    
    private final int [] dx = {1, -1, 0, 0};
    private final int [] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        
        
        return BFS(maps);
    }
    
    public int BFS(int[][] maps) {
        Queue<Location> queue = new LinkedList<>();
        maxRow = maps[0].length;
        maxCol = maps.length;
        boolean [][] visited = new boolean[maxCol][maxRow];
        visited[0][0] = true;
        queue.add(new Location(0,0));
        
        int result = 1;
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++) {
                Location value = queue.poll();
                int row = value.x;
                int col = value.y;
                for(int j=0;j<4;j++) {
                        int newX = row + dx[j];
                        int newY = col + dy[j];
                        if(newX >= maxRow || newY >= maxCol || newX < 0 || newY < 0 
                           || maps[newY][newX] == 0 || visited[newY][newX]) {
                            continue;
                        }
                        if(newX == maxRow - 1 && newY == maxCol - 1) {
                           return result + 1;
                        }
                        visited[newY][newX] = true;
                        queue.add(new Location(newX, newY));  
                }
            }
            result++;
        }
        
        return -1;
    }
    
    public static class Location {
        int x;
        int y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}