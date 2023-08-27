import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N,M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 자신으로 올 수 있는 화살표의 개수를 알아낼 수 있는 변수
        int [] inDegree = new int[N];

        // N개의 수의 연관된 값들의 변수
        ArrayList<Integer> [] lists = new ArrayList[N];
        for(int i=0;i<N;i++)
            lists[i] = new ArrayList<>();

        // M개의 키 비교 결과 입력 ( a b : a가 b보다 앞으로 )
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            lists[a].add(b);
            inDegree[b]++;
        }

        for(int i=0;i<N;i++) {
            // inDegree가 0인 수 알아내서 출력
            int index = getZeroDegree(inDegree);
            bw.write(index+1 + " ");
            // 해당 값으로 연결될 수 잇는 수의 inDegree 다 -1 처리
            ArrayList<Integer> list = lists[index];
            for(int j=0;j<list.size();j++) {
                inDegree[list.get(j)]--;
            }
            inDegree[index]--;
        }

        bw.flush();
        bw.close();
    }

    public static int getZeroDegree(int [] inDegree) {
        int result = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}