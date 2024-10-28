import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap();
        for(String [] c : clothes) {
            if(map.containsKey(c[1])) {
                map.put(c[1], map.get(c[1]) + 1);
            }
            else {
                map.put(c[1], 1);
            }
        }
        
        int result = 1;
        for(int v : map.values()) {
            result = result * (v+1);
        }
        
        return result - 1;
    }
}