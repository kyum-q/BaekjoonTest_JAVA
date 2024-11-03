import java.util.*;

public class Solution {
    public int solution(int n) {
        
        return DFS(n);
    }
    
    public int DFS(int n) {
        if(n == 0) 
            return 0;
        if(n == 1)
            return 1;
        if(n%2 == 0)
            return DFS(n/2);
        return DFS(n-1) + 1;
    }
}