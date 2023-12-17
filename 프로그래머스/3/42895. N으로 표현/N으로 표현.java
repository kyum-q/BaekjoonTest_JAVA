import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {

        Set<Integer> [] dp = new Set[9];

        for (int i = 0; i < 9; i++) {
            dp[i] = new HashSet<>();
        }

        dp[1].add(N);
        if(N == number)
            return 1;

        for (int i = 2; i < 9; i++) {
            for (int j = 1; j <= i/2; j++) {
                unionSet(dp[i], dp[j], dp[i-j]);
                unionSet(dp[i], dp[i-j], dp[j]);
            }
            String n = Integer.toString(N);
            dp[i].add(Integer.parseInt(n.repeat(i))); //연속된 숫자 넣기
            for(int num : dp[i]) {
                if(num == number)
                    return i;
            }
        }

        return -1;
    }

    public void unionSet(Set<Integer> union, Set<Integer> a, Set<Integer> b) {
        for (int n1 : a) {
            for(int n2 : b) {
                union.add(n1 + n2);
                union.add(n1 - n2);
                union.add(n1 * n2);
                if(n2 != 0)
                    union.add(n1/n2);
            }
        }
    }
}
