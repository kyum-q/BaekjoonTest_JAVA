import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] nums = new int[N][M];
        int min = 0, max = 257;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, nums[i][j]);
                max = Math.max(max, nums[i][j]);
            }
        }

        int resultFloor = 0;
        int resultTime = 99999999;
        for (int floor = min; floor <= max; floor++) {
            int b = B;
            int newTime = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (floor > nums[i][j]) {
                        b -= floor - nums[i][j];
                        newTime += floor - nums[i][j];
                    } else if (floor < nums[i][j]) {
                        b += nums[i][j] - floor;
                        newTime += ((nums[i][j] - floor) * 2);
                    }
                }
            }
            if(b < 0) {
                break;
            }
            if(newTime <= resultTime) {
                resultTime = newTime;
                resultFloor = floor;
            }
        }

        System.out.println(resultTime + " " + resultFloor);
    }
}
