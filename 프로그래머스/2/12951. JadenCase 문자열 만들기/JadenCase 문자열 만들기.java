class Solution {
    public String solution(String s) {
        String answer = ""; 
        
        String[] words = s.split(" ", -1); 
        
        for (String word : words) {
            if (!word.isEmpty()) {
                answer += Character.toUpperCase(word.charAt(0));
                if (word.length() > 1) {
                    answer += word.substring(1).toLowerCase();
                }
            }
            answer += " ";
        }
        
        return answer.substring(0, answer.length() -1 ); 
    }
}