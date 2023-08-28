import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 변수 초기화
        lists = new ArrayList[N];
        for (int i = 0; i < N; i++)
            lists[i] = new ArrayList<>();
        int[] inDegrees = new int[N];
        int[] building = new int[N];

        // N개의 건물들을 짓는데 걸리는 시간과 필요한 자원 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            building[i] = time;

            while (st.countTokens() > 1) {
                int material = Integer.parseInt(st.nextToken()) - 1;
                inDegrees[i]++;
                lists[material].add(i);
            }
        }

        int [] sum = new int[N];
        // 각 건물을 건설할 때 필요한 건설 시간 알아내기
        for (int i = 0; i < N; i++) {
            int index = getZeroDegree(inDegrees);

            // 현재 건물이 이미 건설되었을 경우에 대한 처리
            if (sum[index] == 0)
                sum[index] = building[index];
            else
                sum[index] = Math.max(sum[index], building[index]);

            ArrayList<Integer> list = lists[index];
            for(int j=0;j<list.size();j++) {
                int material = list.get(j);
                // 선행 건물을 통해 짓는 경우와 직접 짓는 경우 중 더 오래 걸리는 시간을 선택
                sum[material] = Math.max(sum[material], sum[index] + building[material]);
                inDegrees[material]--;
            }
        }

        // 각 건물을 건설할 때 필요한 건설 시간 출력
        for (int i = 0; i < N; i++) {
            bw.write(sum[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int getZeroDegree(int [] inDegree) {
        int index = 0;

        for(int i=0;i<inDegree.length;i++) {
            if(inDegree[i] == 0) {
                index = i;
                break;
            }
        }
        inDegree[index]--;

        return index;
    }
}