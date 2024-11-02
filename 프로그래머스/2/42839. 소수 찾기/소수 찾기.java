import java.util.*;

class Solution {
    
    public Set<Integer> list = new HashSet<>();
    public int solution(String numbers) {        
        setNum(numbers.toCharArray(), new boolean[numbers.length()], "");
        int answer = 0;
        for(int n : list) {
            System.out.println(n);
            if(check(n)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void setNum(char [] nums, boolean [] visited, String s) {
        if(!s.equals(""))
            list.add(Integer.parseInt(s));
        if(nums.length == s.length()) {
            return;
        }   
        
        for(int i=0;i<nums.length;i++) {
            if(!visited[i]) {
                visited[i] = true;
                setNum(nums, visited, s+nums[i]);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(int n) {
        if(n==0 || n == 1) {
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
}