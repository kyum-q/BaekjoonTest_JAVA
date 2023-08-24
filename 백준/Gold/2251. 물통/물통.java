import java.io.*;
import java.util.*;

public class Main {
    // 확인해야할 sender -> receiver 정리
    static int[] sender = {0,0,1,1,2,2};
    static int[] receiver = {1,2,0,2,0,1};

    // a가 비워졌을 때 c의 값일 경우에만 true
    static boolean [] results = new boolean[201];
    static boolean [][] visited = new boolean[201][201];
    static int [] input = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A,B,C 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        input[0] = Integer.parseInt(st.nextToken());
        input[1] = Integer.parseInt(st.nextToken());
        input[2] = Integer.parseInt(st.nextToken());

        BFS();

        // true인 경우만 i 출력 (그때가 a가 비워졌을 때, c가 가능한 값)
        for(int i=0;i<=input[2];i++) {
            if (results[i]) System.out.print(i + " ");
        }
    }

    static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        results[input[2]] = true;

        while(!queue.isEmpty()) {
            AB now = queue.poll();
            int A = now.A;
            int B = now.B;
            int C = input[2] - (now.A + now.B);
            // 가능한 6개의 케이스 반복
            for(int i=0;i<6;i++) {
                int[] next = {A,B,C};
                // sender에 있는 물 한계 생각 안하고 그냥 다 붓기
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;
                // 가능한 양이 넘칠 경우,
                // 넘치는 양만큼 sender로 이동시키고
                // receiver는 가질 수 있는 최댓값으로
                int reciver = receiver[i];
                if(next[reciver] > input[reciver]) {
                    next[sender[i]] = next[reciver] - input[reciver];
                    next[reciver] = input[reciver];
                }
                int a = next[0];
                int b = next[1];
                // 아직 확인하지 않은 경우
                if(!visited[a][b]) {
                    queue.add(new AB(a, b));
                    visited[a][b] = true;
                    // a가 0인 경우
                    if(a == 0)
                        results[input[2] - (a+b)] = true;
                }
            }
        }
    }

    static class AB {
        int A;
        int B;
        public AB(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}