import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int binaryCount = getBinaryOneCount(Integer.toBinaryString(n));
        for(answer=n+1;binaryCount != getBinaryOneCount(Integer.toBinaryString(answer));answer++) {
        }
        
        return answer;
    }
    
    public int getBinaryOneCount(String binary) {
        int count = 0;
        char [] chars = binary.toCharArray();
        for(char c : chars) {
            if(c == '1') count ++; 
        }
        return count;
    }
}