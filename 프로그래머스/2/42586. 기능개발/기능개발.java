import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> check = new HashMap<>();

        for (int i = 0; i < progresses.length; i++) {
            check.put(i, progresses[i]);
        }

        int index = 0;
        while(index < progresses.length) {
            if(check.get(index) >= 100) {
                int count = 0;
                for (int i = index; i < progresses.length; i++) {
                    int value = check.get(i);
                    if(value >= 100) {
                        count++;
                    }
                    else
                        break;
                }

                result.add(count);
                index = index+count;
            }

            for (int i = index; i < progresses.length; i++) {
                check.put(i, check.get(i) + speeds[i]);
            }
        }

        int [] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
