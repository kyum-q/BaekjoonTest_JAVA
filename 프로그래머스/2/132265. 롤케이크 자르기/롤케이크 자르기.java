import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> second = new HashMap<>();
        
        for(int n : topping) {
            if(first.containsKey(n)) {
                first.put(n, first.get(n) + 1);
            }
            else {
                first.put(n, 1);
            }
        }
        
        for(int n : topping) {
            if(first.get(n) == 1) {
                first.remove(n);
            }
            else {
                first.put(n, first.get(n) - 1);
            }
            
            if(second.containsKey(n)) {
                second.put(n, second.get(n) + 1);
            }
            else {
                second.put(n, 1);
            }
            if(first.size() == second.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}