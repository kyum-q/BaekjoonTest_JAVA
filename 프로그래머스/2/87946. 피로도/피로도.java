import java.util.*;

class Solution {
    
    public int solution(int k, int[][] dungeons) {
        return check(0, k, dungeons, new boolean[dungeons.length]);
    }
    
    public int check(int count, int k, int[][] d, boolean[] visited) {
        int result = count;

        for(int i=0;i<d.length;i++) {
            if(!visited[i] && d[i][0] <= k) {
                visited[i] = true;
                int value = check(count+1, k - d[i][1], d, visited);
                result = Math.max(result, value);
                visited[i] = false;
            }
        }
        return result;
    }
}