import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {       
        Queue<Process> process = new LinkedList<>();
        Queue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<priorities.length;i++) {
            process.add(new Process(i, priorities[i]));
            priority.add(priorities[i]);
        }
        
        int result = 0;
        while(!priority.isEmpty()) {
            int p = priority.peek();
            Process pro = process.poll();
            while(p != pro.priority) {
                process.add(pro);
                pro = process.poll();
            }
            priority.poll();
            result++;
            if(pro.index == location) {
                return result;
            }
        }
        
        return 0;
    }
    
    public static class Process {
        int index;
        int priority;
        
        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}