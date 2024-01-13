import java.util.Arrays;
import java.util.Collections;

class Solution {

    public static void main(String[] args) {
        new Solution().solution(new String[]{"119", "120", "1195524421"});
    }
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Collections.reverseOrder());

        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i].startsWith(phone_book[i+1]))
                return false;

        }

        return true;
    }
}