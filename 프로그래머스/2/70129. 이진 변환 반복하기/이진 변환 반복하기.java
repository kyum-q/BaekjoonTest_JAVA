class Solution {
    public int[] solution(String s) {
        int[] answer = new int [2];
        
        while(!s.equals("1")) {
            char [] nums = s.toCharArray();
            int count = 0;
            for(char num : nums) {
                if(num == '0') answer[1]++;
                else count++;
            }
            
            s = String.valueOf(Integer.toBinaryString(count));
            answer[0]++;
        }
        
        return answer;
    }
}