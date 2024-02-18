import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        new Solution().solution(2,10, new int[]{7, 4, 5, 6});
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int sumWeight = 0;
        Queue<Integer> queue = new LinkedList<>();

        int index = 0;
        while(index < truck_weights.length) {
            if(queue.size()+1 > bridge_length) {
                sumWeight -= queue.poll();
            }
            if(sumWeight+truck_weights[index] > weight) {
                queue.add(0);
            }
            else {
                sumWeight += truck_weights[index];
                queue.add(truck_weights[index]);
                index++;
            }
            answer++;
        }

        return answer+bridge_length;
    }
}