import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {        
        int [] list = new int [(int)(right - left + 1)];
        
        long start = left % n;
        int line = (int) (left / n) + 1; 
        int index = 0;
        int count = 0;
        for(int i=0;i<line;i++) {
            if(count++ - start >= 0) {
                if(index >= list.length)
                    break;
                list[index++] = line;
            }
        }
        for(int i=line+1;i<=n;i++) {
            if(count++ - start >= 0) {
              if(index >= list.length)
                    break;
                list[index++] = i;
            }
        }
        line++;
        
        while(index < list.length) {
            for(int i=0;i<line;i++) {
                if(index >= list.length)
                    break;
                list[index++] = line;
            }
            for(int i=line+1;i<=n;i++) {
                if(index >= list.length)
                    break;
                list[index++] = i;
            }
            line++;
        }
        return list;
    }
}