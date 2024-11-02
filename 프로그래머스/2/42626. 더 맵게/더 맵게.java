import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) {
            queue.add(s);
        }
        
        int answer = 0;
        while(queue.peek() < K) {
            if(queue.size() < 2) {
                return -1;
            }
            int value = queue.poll();
            queue.add(value + queue.poll() * 2);
            answer++;
        }
        
        return answer;
    }
}