import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> talks = new HashSet<>();
        
        char last = words[0].charAt(0);
        for(int i=0;i<words.length;i++) {
            String word = words[i];
            if(talks.contains(word) || last != word.charAt(0)) {
                int person = (i+1) % n;
                if(person == 0) 
                    return new int[] {n, (i + 1) / n };
                return new int[] {person, (i+1) / n + 1};
            }
            last = word.charAt(word.length() - 1);
            talks.add(word);
        }
        
        return new int[]{0, 0};
    }
}