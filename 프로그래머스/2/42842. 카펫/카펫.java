import java.util.*;

class Solution {
    
    public int[] solution(int brown, int yellow) {
        ArrayList<int []> lists = getList(yellow);
        for(int [] list : lists) {
            System.out.println(list[0] +"," + list[1]);
            if(list[0] * list[1] - yellow == brown) {
                return list;
            }
        }
        
        return new int[]{1,1};
    }
    
    public ArrayList<int []> getList(int yellow) {
        ArrayList<int []> list = new ArrayList<>();
        for(int i = 1; i<=Math.sqrt(yellow);i++) {
            if(yellow % i == 0) {
                list.add(new int[]{yellow/i + 2, i + 2});
            }
        }
        return list;
    }
}