import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int t : tangerine) {
            if(map.containsKey(t))
                map.put(t, map.get(t) + 1);
            else
                map.put(t, 1);
        }
        
        List<Integer> values = map.values().stream().collect(Collectors.toList());;
        Collections.sort(values, Collections.reverseOrder());
        int count = k;
        for(int n : values) {
            System.out.println(n);
            answer++;
            count -= n;
            if(count <= 0) {
                return answer;
            }
        }
        
        return answer;
    }
}