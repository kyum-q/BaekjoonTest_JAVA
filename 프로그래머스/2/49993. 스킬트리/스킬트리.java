import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String s : skill_trees) {
            char [] check = s.toCharArray();
            int orderCount = 0;
            boolean isBreak = false;
            for(char c : check) {
                int index = skill.indexOf(c);
                if(index != -1 && index != orderCount) {
                    isBreak = true;
                    break;
                }
                if(index == orderCount) {
                    orderCount++;
                }
            }
            if(!isBreak) {
                answer++;
            }
            
        }
        
        return answer;
    }
}