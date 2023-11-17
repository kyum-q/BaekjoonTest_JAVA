import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int testNum = sc.nextInt();

            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < 1000; i++) {
                int num = sc.nextInt();
                if(treeMap.containsKey(num)) {
                    treeMap.put(num, treeMap.get(num)+1);
                }
                else {
                    treeMap.put(num, 1);
                }
            }

            int max = 0;
            int maxNum = 0;
            for (int i = 0; i < 101; i++) {
                if(treeMap.get(i) >= max) {
                    max = treeMap.get(i);
                    maxNum = i;
                }
            }

            System.out.printf("#%d %d\n", test_case, maxNum);
        }
    }
}
