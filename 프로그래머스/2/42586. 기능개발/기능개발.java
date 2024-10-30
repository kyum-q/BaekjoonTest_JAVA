import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> results = new ArrayList<>();
        
        for(int i=0;i<progresses.length;i++) { 
            int sum = ((100 - progresses[i]) % speeds[i] == 0) 
                ? (100 - progresses[i]) / speeds[i]
                : (100 - progresses[i]) / speeds[i] + 1;
            
            int result = 1;
            for(int j=i+1;j<progresses.length;j++) {
                if(progresses[j] + (speeds[j] * sum) < 100) {
                    break;
                }
                result++;
                i++;
            }
            results.add(result);
        }
        
        int [] answer = new int [results.size()];
        for(int i=0;i<results.size();i++) {
            answer[i] = results.get(i);
        }
        
        return answer;
    }
}