import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String city : cities) {
            city = city.toLowerCase();
            if(!map.containsKey(city)) {
                if(!map.isEmpty() && map.size() == cacheSize) {
                    String firstKey = map.keySet().iterator().next(); 
                    map.remove(firstKey); 
                }
                if(map.size() +1 <= cacheSize) {
                    map.put(city, 0);
                }
                answer += 5;
                continue;
            }
            map.remove(city);
            map.put(city, 0);
            answer++;
        }
        
        return answer;
    }
}