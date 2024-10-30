import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        
        Queue<Node> queue = new PriorityQueue<>();
        for(int i=0;i<prices.length;i++) {
            while(!queue.isEmpty() && queue.peek().value > prices[i]) {
                Node node = queue.poll();
                answer[node.index] = i - node.index;
            }
            queue.add(new Node(i, prices[i]));
        }
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            answer[node.index] = prices.length - 1 - node.index;
        }
        
        return answer;
    }
    
    public static class Node implements Comparable<Node> {
        int index;
        int value;
        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
        
        @Override
        public int compareTo(Node o) {
            if(value == o.value) {
                return index - o.index;
            }
            return o.value - value;
        }
    }
}