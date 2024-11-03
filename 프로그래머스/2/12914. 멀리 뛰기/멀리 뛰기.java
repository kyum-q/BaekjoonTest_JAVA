class Solution {
    public int [] dp;
    public long solution(int n) {
        long answer = 0;
        
        dp = new int [n+1];
        dp[1] = 1;
        if(n >= 2) { 
            dp[2] = 2;
        }
        
        return count(n) % 1234567;
    }
    
    public int count(int n) {
        if(dp[n] != 0) {
            return dp[n];
        }
        dp[n] = count(n-1) + count(n-2) % 1234567;
        return dp[n];
    }
}