import java.util.*;

class Solution {
    public Set<Integer> set = new HashSet<>();
    public int solution(int[] elements) {
        boolean [] visited = new boolean[elements.length];
        for(int i=0;i<elements.length;i++) {
            visited[i] = true;
            sum(1, i, elements[i], elements, visited);
            visited[i] = false;
        }
        return set.size();
    }
    
    public void sum(int count, int index, int value, int[] elements, boolean[] visited) {
        set.add(value);        
        if(count == elements.length) {
            return;
        }
        
        int next = (index + 1 >= elements.length)?0:index+1;
        
        if(!visited[next]) {
            visited[next] = true;
            sum(count+1, next, value + elements[next], elements, visited);
            visited[next] = false;
        }
    }
}