import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            String item = discount[i];
            map.put(item, map.getOrDefault(item, 0) - 1);
        }
        
        if (checkMap(map)) result++;
        
        int start = 0;
        int end = 10;
        while (start < discount.length) {
            String startItem = discount[start];
            map.put(startItem, map.getOrDefault(startItem, 0) + 1);
            start++;
            
            if(end < discount.length) {
                String endItem = discount[end];
                map.put(endItem, map.getOrDefault(endItem, 0) - 1);
                end++;
            }
            
            if (checkMap(map)) result++;
        }
        
        return result;
    }
    
    private boolean checkMap(Map<String, Integer> map) {
        for (int count : map.values()) {
            if (count > 0) return false;
        }
        return true;
    }
}
