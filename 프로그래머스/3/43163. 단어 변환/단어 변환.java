class Solution {
    public static String target;
    public static String [] words;
    public static void main(String[] args) {
        String [] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int result = new Solution().solution("hit","cog",words);
        System.out.println(result);
    }
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;

        boolean [] visit = new boolean[words.length];

        int answer = DFS(begin, -1, 0, visit);

        return answer;
    }

    public static int DFS(String begin, int index, int sum, boolean [] visit) {
        if(words.length <= index)
            return 0;
        if(begin.equals(target))
            return sum;

        int gapSize;

        int min = 9999;
        for (int j = 0; j < words.length; j++) {
            if(j == index) continue;
            String next = words[j];
            gapSize = 0;
            for (int i = 0; i < next.length(); i++) {
                if (next.charAt(i) != begin.charAt(i)) {
                    gapSize++;
                }
            }
            if(gapSize <= 1 && !visit[j]) {
                visit[j] = true;
                int result = DFS(next, j, sum+1, visit);
                if(result != 0)
                    min = Math.min(min, result);
                visit[j] = false;
            }
        }
        if(min == 9999)
            return 0;
        else
            return min;
    }
}

