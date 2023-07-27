import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 숫자들을 index번호와 함께 저장하는 배열 입력
        Node [] nums = new Node[N];

        for (int i = 0; i < N; i++) {
            nums[i] = new Node(i, Integer.parseInt(br.readLine()));
        }

        // 배열 정렬
        Arrays.sort(nums, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.value > o2.value)
                    return 1;
                else if(o1.value < o2.value)
                    return -1;
                else
                    return 0;
            }
        });

        // 정렬 후 배열에 index와 현재 i 값을 비교해 왼쪽으로 이동한 최대 수가 max 값
        int max = 0;

        for (int i = 0; i < N; i++) {
            if(max < nums[i].index - i) {
                max = nums[i].index - i;
            }
        }

        // max 출력
        System.out.println(max+1);
    }
}

class Node {
    public int index;
    public int value;
    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

}