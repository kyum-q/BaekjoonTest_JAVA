import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> list = new Stack<>();
        char [] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++) {
            if(!list.isEmpty() && chars[i] == list.peek()) {
                list.pop();
                continue;
            }
            list.add(chars[i]);
        }
        
        if(list.isEmpty()) return 1;
        return 0;
    }
}