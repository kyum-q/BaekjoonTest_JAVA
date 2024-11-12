import java.util.*;

public class Solution {

    private final Map<String, Integer> docs = new HashMap<>();

    public int[] solution(String msg) {
        for(char c = 'A'; c <= 'Z'; c++) {
            docs.put(String.valueOf(c), c -'A' + 1);
        }

        ArrayList<Integer> zip = new ArrayList<>();

        char [] chars = msg.toCharArray();

        for(int i=0;i < chars.length;i++) {
            String c = String.valueOf(chars[i]);
            while(i+1 < chars.length && docs.containsKey(c + chars[i+1])) {
                c += chars[++i];
            }

            zip.add(docs.get(c));

            if(i+1 < chars.length) {
                char next = chars[i+1];
                docs.put(c + next, docs.size() + 1);
            }
        }

        int [] answer = new int [zip.size()];
        for(int j=0;j<zip.size();j++) {
            answer[j] = zip.get(j);
        }

        return answer;
    }
}
