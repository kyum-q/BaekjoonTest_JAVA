import java.io.*;
import java.util.*;

public class Main {
    public static int [] collection;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N,M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 모든 사람 각 집합으로 생성
        collection = new int[N+1];
        for(int i=0;i<=N;i++) {
            collection[i] = i;
        }

        // 진실을 아는 사람 k명 주어지기 - 진실을 아는 경우 -1 집합으로 설정
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for(int i=0;i<K;i++) {
            int person = Integer.parseInt(st.nextToken());

            collection[person] = -1;
        }

        // M개의 파티의 참여하는 사람을 arraylist로 설정
        ArrayList<Integer> [] parties = new ArrayList[M];

        // M개의 파티 입력
        for(int i=0;i<M;i++) {
            parties[i] = new ArrayList<>();
            ArrayList<Integer> party = parties[i];

            // 파티에 참여하는 사람 k명 입력
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            for(int j=0;j<K;j++) {
                int person = Integer.parseInt(st.nextToken());

                if(!party.isEmpty()) {
                    // party에 있는 사람과 동일 집합으로 설정
                    union(party.get(j -1), person);
                }

                // i번째 파티 참여하는 사람으로 추가
                party.add(person);
            }
        }

        // 과장해서 말할 수 있는 파티 개수
        int count = 0;

        // 모든 파티에서 진실을 아는집합이 없을 경우(-1 집합이 없을 경우)에만 count 증가
        for(int i=0;i<parties.length;i++) {
            ArrayList<Integer> party = parties[i];

            // 진실을 아는지 확인 변수
            boolean isTrust = false;

            // 파티 참여인들을 확인하면서 -1 집합인 사람이 있을 경우 isTrust 변경 후 종료
            for(int j=0;j<party.size();j++) {
                if(find(party.get(j)) == -1) {
                    isTrust = true;
                    break;
                }
            }

            // 진실을 아는 사람이 없을 경우만 count 증가
            if(!isTrust) {
                count++;
            }
        }

        // 과장할 수 있는 횟수 출력
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }

    public static void union(int a, int b) {
        int mainA = a, mainB = b;
        if(a != collection[a]) {
            if(collection[a] == -1) mainA = -1;
            else mainA = find(a);
        }
        if(b != collection[b]) {
            if(collection[b] == -1) mainB = -1;
            else mainB = find(b);
        }

        if(mainB == -1) {
            if(mainA != -1)
                collection[mainA] = -1;
        }
        else {
            collection[mainB] = mainA;
        }
    }

    public static int find(int a) {
        // 자신이 대표 노드이거나, 자신의 집합이 -1 집합으로 진실을 아는 집합일 경우 return
        if(a == collection[a] || collection[a] == -1)
            return collection[a];

        // 그게 아니면 노드의 값으로 다시 대표노드를 찾아 변경 후 리턴
        collection[a] = find(collection[a]);
        return collection[a];
    }
}