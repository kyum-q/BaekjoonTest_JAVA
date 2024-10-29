public class Solution {

    public static void main(String[] args) {
        int result = new Solution().solution("hit", "cog", new String[]{
                "hot", "dot", "dog", "lot", "log", "cog"
        });
        System.out.println(result);  // Expected output: 4
    }

    private boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        int result = BFS(begin, target, words);
        return result == Integer.MAX_VALUE ? 0 : result - 1;
    }

    public int BFS(String begin, String target, String[] words) {
        if (begin.equals(target)) {
            return 1;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;  // 이미 방문한 단어는 스킵

            int count = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) != begin.charAt(j)) {
                    count++;
                    if (count > 1) break;
                }
            }

            if (count == 1) {  // 한 글자만 다른 경우에만 진행
                visited[i] = true;
                int bfsResult = BFS(words[i], target, words);
                if (bfsResult != Integer.MAX_VALUE) {
                    result = Math.min(result, bfsResult + 1);
                }
                visited[i] = false;  // 탐색이 끝난 후 방문 해제
            }
        }
        return result;
    }
}
