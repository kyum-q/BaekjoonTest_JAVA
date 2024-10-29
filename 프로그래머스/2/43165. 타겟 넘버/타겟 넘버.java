class Solution {
    private static int[][] results;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        results = new int[numbers.length][numbers.length];
        
        return DFS(numbers, 0, 0, target);
    }
    
    public int DFS(int[] numbers, int current, int value, int target) {
        if(current == numbers.length) {
            if(value == target)
                return 1;
            return 0;
        }
        
        return DFS(numbers, current +1, value + numbers[current], target)
            + DFS(numbers, current +1, value - numbers[current], target);
    }
}

/*
*/
