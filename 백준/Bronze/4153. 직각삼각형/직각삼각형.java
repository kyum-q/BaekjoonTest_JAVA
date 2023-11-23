import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean run = true;
        while (run) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] nums = new int[3];

            for (int i = 0; i < 3; i++) {
                int num = Integer.parseInt(st.nextToken());
                nums[i] = num * num;
            }

            Arrays.sort(nums);

            if(Arrays.stream(nums).allMatch(n -> n ==0))
                break;

            if(nums[2] == nums[0] + nums[1]) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
        }
    }
}
