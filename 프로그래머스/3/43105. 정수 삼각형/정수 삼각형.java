import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int [] parent = new int [3];
        parent[1] = triangle[0][0];

        for(int i=1;i<triangle.length;i++) {
            int [] current = new int [i+3];
            for(int j=0;j<triangle[i].length;j++) {
                current[j+1] = triangle[i][j] + Math.max(parent[j], parent[j+1]);
            }
            parent = current;
        }

        int max = 0;
        for(int i=1;i<parent.length;i++) {
            max = Math.max(max, parent[i]);
        }

        return max;
    }
}