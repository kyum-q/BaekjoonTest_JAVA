import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 작업 목록을 Node 객체로 변환
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int[] job : jobs) {
            queue.offer(new Node(job[0], job[1]));
        }
        
        int current = 0;
        int totalWaitTime = 0;
        
        // 요청 시간 오름차순 정렬을 위한 큐
        PriorityQueue<Node> taskQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.value));
        
        while (!queue.isEmpty() || !taskQueue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek().start <= current) {
                taskQueue.offer(queue.poll());
            }
            
            if (taskQueue.isEmpty()) {
                current = queue.peek().start;
            } else {
                Node task = taskQueue.poll();
                current += task.value;
                totalWaitTime += current - task.start;
            }
        }
        
        return totalWaitTime / jobs.length;
    }
    
    public static class Node implements Comparable<Node> {
        int start;
        int value;

        public Node(int start, int value) {
            this.start = start;
            this.value = value;
        }

        @Override
        public int compareTo(Node other) {
            if (this.start == other.start) {
                return this.value - other.value;
            }
            return this.start - other.start;
        }
    }
}
