import java.util.*;

class Solution {
    
    public Map<Long, Long> map = new HashMap<>();
    
    public long solution(int n) {
        map.put(0L, 0L);
        map.put(1L, 1L);
        return fibonach((long)n) % 1234567;
    }
    
    public long fibonach(long current) {
        if(map.containsKey(current)) return map.get(current);
        long result = fibonach(current - 2) + fibonach(current - 1) % 1234567;
        map.put(current, result);
        return result;
    }
}