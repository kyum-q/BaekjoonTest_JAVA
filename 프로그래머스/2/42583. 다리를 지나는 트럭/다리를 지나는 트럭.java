import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int answer = 0;
        int nextIndex = 0;
        for(int i=0;i<bridge_length;i++){
            if(i >= truck_weights.length) {
                return truck_weights.length + bridge_length;
            }
            if(sum + truck_weights[i] > weight) {
                for(int j=i;j<bridge_length;j++){
                    queue.add(0);
                    answer++;
                }
                break;
            }
            queue.add(truck_weights[i]);
            nextIndex++;
            sum += truck_weights[i];
            answer++;
        }
        
        while(!queue.isEmpty()) {
            int value = queue.poll();
            sum -= value;
            
            if(nextIndex >= truck_weights.length) {
                answer++;
                continue;
            }
            if(sum + truck_weights[nextIndex] > weight) {
                queue.add(0);
            }
            else {
                queue.add(truck_weights[nextIndex]);
                sum += truck_weights[nextIndex];
                nextIndex++;
            }
            answer++;
        }
        
        return answer;
    }
}