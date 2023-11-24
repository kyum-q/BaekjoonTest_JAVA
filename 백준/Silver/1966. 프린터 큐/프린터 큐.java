import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Node> nums = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums.add(new Node(i, Integer.parseInt(st.nextToken())));
            }

            int i = 0;
            int count = 0;
            while(nums.size() > 0) {
                int max = Collections.max(nums).important;
                Node value = nums.get(i);
                if(max == value.important) {
                    if(value.index == M) {
                        System.out.println(count+1);
                        break;
                    }
                    else {
                        nums.remove(value);
                        count++;
                        if(i > nums.size()-1) {
                            i = 0;
                        }
                    }
                }
                else {
                    i = (i+1) % nums.size();
                }
            }

        }
    }

    public static class Node implements Comparable<Node> {
        int important;
        int index;

        public Node(int index, int important) {
            this.index = index;
            this.important = important;
        }

        @Override
        public int compareTo(Node o) {
            if(important == o.important) {
                return index - o.index;
            }
            return important - o.important;
        }
    }
}
