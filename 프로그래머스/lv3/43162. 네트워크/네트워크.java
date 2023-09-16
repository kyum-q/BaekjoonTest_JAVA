import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static boolean [] visited;
    public static ArrayList[] lists;
    public static int count = 0;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        lists = new ArrayList[n];
        for(int i=0;i<n;i++) {
            lists[i] = new ArrayList<>();
            for(int j=0;j<computers[i].length;j++) {
                if(j!=i && computers[i][j] == 1) {
                    lists[i].add(j);
                }
            }
        }

        for(int i=0;i<n;i++) {
            BFS(i);
        }
        
        return count;
    }

    public void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        
        if(!visited[index]) {
            visited[index] = true;
            queue.add(index);
            while (!queue.isEmpty()) {
                int queueSize = queue.size();
                for (int i = 0; i < queueSize; i++) {
                    int newIndex = queue.poll();

                    ArrayList<Integer> list = lists[newIndex];

                    for (int j = 0; j < list.size(); j++) {
                        int n = list.get(j);
                        if (!visited[n]) {
                            visited[n] = true;
                            queue.add(n);
                        }
                    }
                }
            }
            count++;
        }
    }
}