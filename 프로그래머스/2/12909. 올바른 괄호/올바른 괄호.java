class Solution {
    boolean solution(String s) {
        char[] chars = s.toCharArray();
        
        int plus = 0;
        for(char c : chars) {
            if(c == '(') {
                plus++;
                continue;
            }
            if(plus == 0) {
                return false;
            }
            plus--;
        }
        
        return plus == 0;
    }
}