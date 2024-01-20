import java.util.TreeMap;

class Solution {
    public int solution(String[][] clothes) {
        TreeMap<String, Integer> map = new TreeMap<>();

        for (String[] clothe : clothes) {
            String kind = clothe[1];
            if (map.containsKey(kind)) {
                map.put(kind, map.get(kind) + 1);
            } else {
                map.put(kind, 1);
            }
        }

        int answer = 1;
        for (int n : map.values()) {
            answer *= (n+1);
        }

        return answer - 1;
    }
}