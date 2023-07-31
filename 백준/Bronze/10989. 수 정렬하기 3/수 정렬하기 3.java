import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 수 입력
        int nums [] = new int[N];
        for(int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // Arrays.sort 정렬
        Arrays.sort(nums);

        // 기수 정렬
        radixSort(nums);

        // 출력
        for(int i=0;i<N;i++){
            bw.write(nums[i]+"\n");
        }

        bw.flush();
        bw.close();
    }

    public static void radixSort(int [] nums) {
        int num2 [] = new int[nums.length];
//
//        for(int i=0;i<10;i++) {
//            queue[i] = new LinkedList<>();
//        }
//        for (int i = 0; i < nums.length; i++) {
//            queue[(nums[i] % 10)].add(nums[i]);
//        }

//        int tenMul = 1;
//        boolean isClear = false;
//
//        while(!isClear) {
//            isClear = true;
//            for (int i = 0; i < nums.length; i++) {
//                if ((tenMul / 10) > 0)
//                    queue[(nums[i] % tenMul) / (tenMul / 10)].add(nums[i]);
//                else
//                    queue[(nums[i] % tenMul)].add(nums[i]);

//                if(nums[i] / tenMul > 0) {
//                    isClear = false;
//                }
//            }
//
//            int k = 0;
//            for (int i = 0; i < 10; i++) {
//                while(!queue[i].isEmpty()) {
//                    nums[k] = queue[i].poll();
//                    k++;
//                }
//            }
//            tenMul *= 10;
//        }
    }
}