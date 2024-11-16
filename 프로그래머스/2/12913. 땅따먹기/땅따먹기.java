import java.util.*;

class Solution {
    int solution(int[][] land) {        
        if(land.length == 0) {
            return 0;
        }
        
        Queue<Node> queue = new PriorityQueue<>();
        
        for(int i=0;i<4;i++) {
            queue.add(new Node(0, i, land[0][i]));
        } 
        
        for(int i=1;i<land.length;i++) {
            for(int j=0;j<4;j++) {
                Queue<Node> check = new LinkedList<>();
                while(queue.peek().j == j) {
                    check.add(queue.poll());
                }
                queue.add(new Node(i, j, queue.peek().value + land[i][j]));
                while(!check.isEmpty()) {
                    queue.add(check.poll());
                }   
            }
            for(int j=0;j<4;j++) {
                queue.poll();
            }
        }
        return queue.poll().value;
    }
    
    public static class Node implements Comparable<Node> {
        int value;
        int i;
        int j;
        
        public Node(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
        
        public int compareTo(Node n) {
            if(i == n.i) {
                if(value == n.value)
                    return j - n.j;
            
                return n.value - value;
            }
            return i - n.i;
        }
    }
}