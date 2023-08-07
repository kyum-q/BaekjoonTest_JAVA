import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // 현재 조건을 만족하는 친구관계가 있는지에 대한 변수
    public static boolean checkFriendShip = false;
    // 해당 index가 검사됬는지 확인하는 변수
    public static boolean [] checkIndex;
    // 각 index의 근접 노드를 저장하는 변수
    public static ArrayList [] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 변수 세팅
        list = new ArrayList[N];

        for(int i=0;i<N;i++) {
            list[i] = new ArrayList();
        }

        // M번 반복해서 수 입력
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            // 인접 노드 등록
            list[first].add(second);
            list[second].add(first);
        }
        br.close();

        // 모든 수를 확인하면서 DFS 확인
        for(int i=0;i<N;i++) {
            checkIndex = new boolean[N];

            DFS(i, 1);
            // 친구관계를 만족했을 경우, 종료
            if(checkFriendShip) break;
        }
        // 친구관계를 만족한 경우 1, 아닌 경우 0 출력
        if(checkFriendShip)
            bw.write("1");
        else
            bw.write("0");

        bw.flush();
        bw.close();
    }

    public static void DFS(int index, int count) {

        // 확인 된 변수 일 경우, return
        if(checkIndex[index]) {
            return;
        }

        // 깊이가 5일 경우 친구관계를 만족한 것이므로 true로 변환 후 return
        if(count == 5)  {
            checkFriendShip = true;
            return;
        }

        // 확인했으니 확인했다고 해당 변수 변환
        checkIndex[index] = true;

        // 지금 연관된 인접노드 확인하면서 count 확인
        for(int i=0;i<list[index].size();i++) {
            DFS((Integer) list[index].get(i), count+1);

            // count가 만족하면 종료
            if(checkFriendShip)
                break;
        }

        // 다음 DFS에 방해되지 않게 초기화
        checkIndex[index] = false;
    }
}