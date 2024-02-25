import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Node> queue = new PriorityQueue<>();

        for (int i = 0; i < prices.length; i++) {
            while (!queue.isEmpty() && queue.peek().price > prices[i]) {
                Node value = queue.poll();
                answer[value.index] = i - value.index;
            }
            queue.add(new Node(prices[i],i));
        }

        while(!queue.isEmpty()) {
            Node value = queue.poll();
            answer[value.index] =prices.length - 1 - value.index;
        }

        return answer;
    }

    public static class Node implements Comparable<Node> {
        int price;
        int index;
        public Node(int price, int index) {
            this.price = price;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            if(price == o.price) {
                return index - o.index;
            }
            return o.price - price;
        }
    }
}
