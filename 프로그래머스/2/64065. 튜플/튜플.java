import java.util.*;

class Solution {

    public int[] solution(String s) {
        String [] strings = s.substring(1, s.length() -2).split("},", -1);
        ArrayList<Integer> [] lists = new ArrayList[strings.length];

        for(String string : strings) {
            String [] tuple = string.substring(1).split(",");
            ArrayList<Integer> list = new ArrayList<>();

            for(String t : tuple) {
                list.add(Integer.parseInt(t));
            }

            lists[tuple.length - 1] = list;
        }

        Set<Integer> set = new LinkedHashSet<>();

        for(ArrayList<Integer> list : lists) {
            for(int i : list) {
                if(!set.contains(i)) {
                    set.add(i);
                }
            }
        }

        Iterator<Integer> iterator = set.iterator();
        int[] answer = new int [set.size()];
        for(int i=0;iterator.hasNext();i++) {
            answer[i] = iterator.next();
        }

        return answer;
    }
}
