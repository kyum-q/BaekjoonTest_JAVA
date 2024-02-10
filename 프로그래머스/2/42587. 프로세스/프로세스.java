import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> processes = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            processes.add(new Process(i, priorities[i]));
        }

        Arrays.sort(priorities);

        int len = priorities.length-1;
        int count = 0;
        while (!processes.isEmpty()) {
            Process p = processes.poll();

            while(p.priority != priorities[len-count]) {
                processes.add(p);
                p = processes.poll();
            }

            if(p.index == location)
                break;

            count++;
        }

        return count+1;
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