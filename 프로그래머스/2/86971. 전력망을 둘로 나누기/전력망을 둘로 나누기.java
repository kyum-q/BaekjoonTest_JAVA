import java.util.*;

class Solution {
    public ArrayList []  lists;
    public int solution(int n, int[][] wires) {
        lists = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            lists[i] = new ArrayList<>();
        }
        
        for(int [] w : wires) {
            lists[w[0]].add(w[1]);
            lists[w[1]].add(w[0]);
        }
        
        return get(wires, n);
    }
    
    public int get(int[][] wires, int n) {
        int result = 101;
        for(int [] wire : wires) {
            boolean [] visited = new boolean[n+1];
            visited[wire[0]] = true;
            visited[wire[1]] = true;
            
            int first = getCount(wire[0], visited);
            int second = getCount(wire[1], visited);
            
            if(first > second) 
                result = Math.min(result, first - second);
            else
                result = Math.min(result, second - first);
        }
        
        return result;
    }
    
    public int getCount(int current, boolean [] visited) {
        ArrayList<Integer> list = lists[current];
        
        int result = 0;
        for(int num : list) {
            if(!visited[num]) {
                visited[num] = true;
                int value = getCount(num, visited);
                result += value + 1;
            }
        }
        return result;
    }
}