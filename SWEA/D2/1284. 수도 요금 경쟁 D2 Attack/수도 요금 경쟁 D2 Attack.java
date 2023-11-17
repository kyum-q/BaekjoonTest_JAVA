import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int P = sc.nextInt(); // A사의 1L당 요금
            int Q = sc.nextInt(); // B사의 RL이하 시 Q 요금
            int R = sc.nextInt();
            int S = sc.nextInt(); // B사의 RL초과 시 1L당 S 요금
            int W = sc.nextInt(); // 한달 사용 수도 양

            int fareA = P * W;
            int fareB = Q;
            if(W > R) {
                fareB += (W-R) * S;
            }



            System.out.printf("#%d %d\n", test_case, Math.min(fareA, fareB));
        }
    }
}
