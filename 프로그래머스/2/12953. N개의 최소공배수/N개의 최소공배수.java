

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        for(int n : arr) {
            answer = lcm(answer, n);
        }
        
        return answer;
    }
    
    public int lcm(int a, int b) {
        int tempA = a;
        int tempB = b;
        while(tempB != 0) {
            int temp = tempA;
            tempA = tempB;
            tempB = temp % tempB;
        }
        return a * b / tempA;
    }
}