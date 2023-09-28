import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, Node> trees = new HashMap<>();

            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                Node a;
                if (trees.containsKey(A)) {
                     a = trees.get(A);
                } else {
                    a = new Node(null, A);
                    trees.put(A, a);
                }
                if(trees.containsKey(B)) {
                    Node b = trees.get(B);
                    b.parent = a;
                }
                else {
                    trees.put(B, new Node(a, B));
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            Node first = trees.get(Integer.parseInt(st.nextToken()));
            Node second = trees.get(Integer.parseInt(st.nextToken()));

            while(first.getDepth() != second.getDepth()) {
                if(first.getDepth() > second.getDepth())
                    first = first.parent;
                else
                    second = second.parent;
            }

            while(first.current != second.current) {
                first = first.parent;
                second = second.parent;
            }

            bw.write(first.current + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static class Node {
        int current;
        Node parent;
        public Node(Node parent, int current) {
            this.parent = parent;
            this.current = current;
        }

        public int getDepth() {
            if(parent != null) {
                return parent.getDepth()+1;
            }
            else return 0;
        }
    }
}