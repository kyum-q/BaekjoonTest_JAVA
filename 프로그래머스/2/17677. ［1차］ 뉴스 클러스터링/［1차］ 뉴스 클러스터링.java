import java.util.*;

class Solution {
    ArrayList<String> set = new ArrayList<>();
    ArrayList<String> check = new ArrayList<>();
    
    public int solution(String str1, String str2) {
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();
        
        int count1 =setString(s1);
        int count2 = check(s2);
        
        if((count1 + count2 - check.size()) == 0) {
            return 65536;
        }
        double result = (double) check.size() / (count1 + count2 - check.size());
        return (int) (result * 65536);
    }
    
    public int setString(String s1) {
        int start = 0;
        int end = 2;
        int count = 0;
        
        while(end <= s1.length()) {
            String s = s1.substring(start, end);
            start++;
            end++;
            
            char [] c = s.toCharArray();
            if(c[0] < 'a' || c[0] > 'z' || c[1] < 'a' || c[1] > 'z') {
                continue;
            }
            set.add(s);
            count++;
            
        }
        return count;
    }
    
    public int check(String s1) {
        int start = 0;
        int end = 2;
        int count = 0;
        
        while(end <= s1.length()) {
            String s = s1.substring(start, end);
            start++;
            end++;
    
            char [] c = s.toCharArray();
            if(c[0] < 'a' || c[0] > 'z' || c[1] < 'a' || c[1] > 'z') {
                continue;
            }
            
            if(set.contains(s)) {
                check.add(s);
                set.remove(s);
            }
            count++;
        }
        return count;
    }
}