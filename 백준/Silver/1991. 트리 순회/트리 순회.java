import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Node [] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            int index = a - 'A';
            nodes[index] = new Node(a,b,c);
        }

        bw.write(getPreorder(nodes, 0) + "\n");
        bw.write(getInorder(nodes, 0) + "\n");
        bw.write(getPostorder(nodes, 0) + "\n");

        bw.flush();
        bw.close();
    }
    public static class Node {
        int left = -1;
        int right = -1;
        char curr;
        public Node(char curr, char left, char right) {
            this.curr = curr;
            if(left != '.')
                this.left = left - 'A';
            if(right != '.')
                this.right = right - 'A';
        }
    }

    public static String getPreorder(Node [] nodes, int index) {
        StringBuilder result = new StringBuilder();

        result.append(nodes[index].curr);
        if(nodes[index].left != -1) {
            result.append(getPreorder(nodes, nodes[index].left));
        }

        if(nodes[index].right != -1) {
            result.append(getPreorder(nodes, nodes[index].right));
        }

        return result.toString();
    }

    public static String getInorder(Node [] nodes, int index) {
        StringBuilder result = new StringBuilder();

        if(nodes[index].left != -1) {
            result.append(getInorder(nodes, nodes[index].left));
        }

        result.append(nodes[index].curr);

        if(nodes[index].right != -1) {
            result.append(getInorder(nodes, nodes[index].right));
        }

        return result.toString();
    }

    public static String getPostorder(Node [] nodes, int index) {
        StringBuilder result = new StringBuilder();

        if(nodes[index].left != -1) {
            result.append(getPostorder(nodes, nodes[index].left));
        }

        if(nodes[index].right != -1) {
            result.append(getPostorder(nodes, nodes[index].right));
        }

        result.append(nodes[index].curr);

        return result.toString();
    }
}