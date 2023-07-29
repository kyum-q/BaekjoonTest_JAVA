import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 사람별 P 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] P = new int [N];
        for(int i=0;i<N;i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

//        for(int i=0;i<N;i++) {
//            int currentP = P[i];
//
//            // P를 오름차순으로 정렬
//            for(int j=i-1;j>=0;j--) {
//                if(P[j] > currentP) {
//                    P[j+1] = P[j];
//                }
//                else {
//                    P[j+1] = currentP;
//                    break;
//                }
//            }
//        }

        int result = 0;
        int [] sums = new int [N];

        Arrays.sort(P);
        for(int i=0;i<N;i++) {
            if(i == 0)
                sums[i] = P[i];
            else
                sums[i] = sums[i-1] + P[i];

            result += sums[i];
        }

        System.out.println(result);
    }
}
