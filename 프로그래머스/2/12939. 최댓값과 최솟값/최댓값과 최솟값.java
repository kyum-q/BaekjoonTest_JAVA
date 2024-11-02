import java.util.*;

class Solution {
    public String solution(String s) {        
        String [] strings = s.split(" ");
        int [] nums = new int [strings.length];
        for(int i=0;i<strings.length;i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        
        Arrays.sort(nums);
        
        return nums[0] +" " +nums[nums.length-1];
    }
}