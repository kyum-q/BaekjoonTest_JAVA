import java.util.*;

class Solution {
    public ArrayList<String> list = new ArrayList<>();
    public char [] alphs = new char[]{'A','E','I','O','U'};
    
    public int solution(String word) {
        setString(5, 0, "");
        
        Collections.sort(list);
        
        // for(String s : list) {
        //     System.out.println(s);
        // }
        
        return list.indexOf(word) + 1;
    }
    
    public void setString(int max, int index, String s) {
        if(!s.equals("")) {
            list.add(s);
        }
        if(index == max) {
            return;
        }
        for(char c : alphs) {
            setString(max, index+1, s+c);
        }
    }
}