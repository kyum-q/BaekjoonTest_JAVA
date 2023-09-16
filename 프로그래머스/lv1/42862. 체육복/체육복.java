import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        // 여분 옷을 가져왔음을 쉽게 알기 위해 ArrayList로 제작
        ArrayList<Integer> reserveList = new ArrayList<>();
        for(int i=0;i<reserve.length;i++) {
            reserveList.add(reserve[i]);
        }

        // 옷 도난 당했음을 쉽게 알기 위해 ArrayList로 제작
        ArrayList<Integer> lostList = new ArrayList<>();
        for(int i=0;i<lost.length;i++) {
            lostList.add(lost[i]);
        }
        
        // 정렬
        Collections.sort(reserveList);
        Collections.sort(lostList);

        // 잃어버린 애들만 확인해서,
        // 본인 혹은 위 아래 애 중에 여분 옷을 가져온 애가 있는지 확인하고
        // 있으면 가져온 애 목록에서 제거
        for(int i=0;i<lostList.size();i++) {
            int index = lostList.get(i);

            if (lostList.contains(index)) {
                // 본인 확인
                if (reserveList.contains(index)) {
                    reserveList.remove((Integer) (index));
                }
                // 아래 애 확인
                else if (reserveList.contains(index - 1)) {
                    reserveList.remove((Integer) (index - 1));
                }
                // 위 애 확인 (위 애가 본인이 도난 당했으면 자기가 사용해야하므로 제외)
                else if (reserveList.contains(index + 1) && !lostList.contains(index + 1)) {
                    reserveList.remove((Integer) (index + 1));
                }
                // 아무도 안 가져왔을 경우, 체육 할 수 있는 인원 1 감소
                else {
                    answer--;
                }
            }
        }

        return answer;
    }
}