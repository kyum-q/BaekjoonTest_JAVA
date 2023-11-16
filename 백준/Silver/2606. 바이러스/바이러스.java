import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int computerN = Integer.parseInt(br.readLine());
        int pairN =  Integer.parseInt(br.readLine());

        ArrayList<Integer> [] pairs = new ArrayList[computerN+1];
        for (int i = 1; i <= computerN; i++) {
            pairs[i] = new ArrayList<>();
        }

        for (int i = 0; i < pairN; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pairs[a].add(b);
            pairs[b].add(a);
        }

        System.out.println(BFS(pairs, 1));
    }

    static public int BFS(ArrayList<Integer> [] pairs, int index) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[pairs.length];

        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int newIndex = queue.poll();

            ArrayList<Integer> pair = pairs[newIndex];
            for(int i=0;i<pair.size();i++) {
                int num = pair.get(i);
                if(!visited[num]) {
                    queue.add(num);
                    visited[num] = true;
                    count++;
                }
            }
        }

        return count;
    }

}