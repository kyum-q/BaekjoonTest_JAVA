class Solution {
    public int solution(int n) {
        int result = 0;
        for(int i=1;i<=n;i++) {
            result += get(n, 0, i);
        }
        return result;
    }
    
    public int get(int n, int current, int index) {
        if(n == current) {
            return 1;
        }
        if(n < current) {
            return 0;
        }
        return get(n, current + index, index + 1);
    }
}