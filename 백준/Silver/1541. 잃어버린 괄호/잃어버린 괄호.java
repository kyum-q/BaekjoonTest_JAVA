import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수 입력
        String s = br.readLine();

        int result = 0;
        String [] minusNum = s.split("-");
        for(int i=0;i<minusNum.length;i++) {
            String [] plusNum = minusNum[i].split("\\+");
            int sum = 0;
            for(int j=0;j<plusNum.length;j++) {
                sum += Integer.parseInt(plusNum[j]);
            }
            if(i == 0)
                result = sum;
            else
                result -= sum;
        }

        System.out.println(result);

    }
}