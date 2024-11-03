import java.util.*;

class Solution {
    public Map <Character, Character> match = Map.of(']','[',')','(','}','{');
    
    public int solution(String s) {        
        char [] chars = s.toCharArray();

        int answer = 0;
        Queue<Character> queue = new LinkedList<>();
        for(char c: chars) {
            queue.add(c);
        }
        
        for(int i=0;i<s.length();i++) {
            queue.add(queue.poll());
            if(check(queue)) answer++;
        }
        return answer;
    }
    
    public boolean check(Queue<Character> queue) {
        Stack<Character> stack = new Stack<>();

        for (char value : queue) {
            if (match.containsKey(value)) {
                if (stack.isEmpty() || stack.pop() != match.get(value)) {
                    return false;
                }
            } else {
                stack.push(value);
            }
        }
        
        return stack.isEmpty();
    }
}