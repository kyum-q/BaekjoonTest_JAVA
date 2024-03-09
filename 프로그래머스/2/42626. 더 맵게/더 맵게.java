import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> scovilles = new PriorityQueue<>();

        for(int s : scoville) {
            scovilles.add(s);
        }

        int count = 0;
        boolean isCheck = false;
        while (!scovilles.isEmpty()) {
            int value = scovilles.poll();
            if(value >= K) {
                isCheck = true;
                break;
            }
            if(scovilles.isEmpty()) {
                break;
            }
            scovilles.add(value + (scovilles.poll()*2));
            count++;
        }
        
        if(isCheck) {
            return count;
        }
        return  -1;
    }
}
