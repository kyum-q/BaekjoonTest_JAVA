import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < citations.length; i++) {
            list.add(citations[i]);
        }
        list.sort(Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) >= i && list.get(i) >= i+1) {
                answer = i+1;
            }
        }

        return answer;
    }
}
