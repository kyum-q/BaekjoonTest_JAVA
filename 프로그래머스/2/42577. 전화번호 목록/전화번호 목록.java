import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean solution(String[] phone_book) {
        List<String> list = Arrays.stream(phone_book).sorted().collect(Collectors.toList());
        
        for(int i=0;i<list.size()-1;i++) {
        String value = list.get(i);
            if(list.get(i+1).startsWith(value)) {
                return false;
            }
        }
        
        return true;
    }
}