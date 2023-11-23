import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean isCheck = true;
        int [] nums = new int[9];
        for (int i = 1; i <= 8; i++) {
            nums[i] = Integer.parseInt(st.nextToken());

            if(i > 1 && nums[i] != nums[i-1]+1 && nums[i] != nums[i-1]-1) {
                isCheck = false;
                break;
            }
        }

        if(isCheck) {
            if(nums[1] < nums[2])
                System.out.println("ascending");
            else
                System.out.println("descending");
        }
        else {
            System.out.println("mixed");
        }
    }
}
