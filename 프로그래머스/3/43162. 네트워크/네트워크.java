import java.util.*;

class Solution {
    
    private static boolean [] visited;
    private static ArrayList<Integer> [] connects;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean [n];
        connects = new ArrayList [n];
        for(int i=0;i<n;i++) {
            connects[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(computers[i][j] == 1) {
                    connects[i].add(j);
                    connects[j].add(i);
                }
            }
        }
        
        int result = 0;
        for(int i=0;i<n;i++) {
            if(visited[i]) {
                continue;
            }
            result += DFS(n, i, computers);
        }
        return result;
    }
    
    public int DFS(int n, int value, int [][] computers) {
        if(value < 0 || value >= n) {
            return 0; 
        }
        int result = (visited[value]) ? 0 : 1;
        ArrayList<Integer> connect = connects[value];
        for(int computer : connect) {
            if(visited[computer]) {
                continue;
            }
            visited[computer] = true;
            result += DFS(n, computer, computers);
        }
        return result;
    }
}