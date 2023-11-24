import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] nums = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        Arrays.sort(nums);

        // 최빈수 구하기
        ArrayList<Integer> manyNum = new ArrayList<>();
        int manyCount = -1;
        int checkNum = 9999;
        int checkCount = 0;
        for (int i = 0; i < N; i++) {
            if(checkNum != nums[i]) {
                if(manyCount < checkCount) {
                    manyCount = checkCount;
                    manyNum.clear();
                    manyNum.add(checkNum);
                }
                else if(manyCount == checkCount) {
                    manyCount = checkCount;
                    manyNum.add(checkNum);
                }
                checkCount = 1;
                checkNum = nums[i];
            }
            else {
                checkCount++;
            }
        }
        if(manyCount < checkCount) {
            manyCount = checkCount;
            manyNum.clear();
            manyNum.add(checkNum);
        }
        else if(manyCount == checkCount) {
            manyCount = checkCount;
            manyNum.add(checkNum);
        }

        Collections.sort(manyNum);
        int frequent = (manyNum.size() >= 2) ? manyNum.get(1) : manyNum.get(0);
        int avg = (int) Math.round((double)sum/N);
        int mid = nums[N/2];
        int maxToMin = nums[N-1] - nums[0];

        bw.write(avg+"\n");
        bw.write(mid+"\n");
        bw.write(frequent+"\n");
        bw.write(maxToMin+"\n");
        bw.flush();
        bw.close();
    }
}
