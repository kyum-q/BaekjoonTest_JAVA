import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        ArrayList<String> s = new ArrayList<>();
        for(int i=0;i<numbers.length;i++) {
            s.add(String.valueOf(numbers[i]));
        }
        
        Collections.sort(s, (a, b) -> (b + a).compareTo(a + b));

        if (s.get(0).equals("0")) {
            return "0";
        }
        
        for(int i=0;i<s.size();i++) {
            answer += s.get(i);
        }
        
        return answer;
    }
}