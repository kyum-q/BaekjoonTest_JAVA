import java.io.*;
import java.util.*;

public class Main {
    public static int [] collection;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N,M 입력
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // N개의 집합 생성
        collection = new int [N+1];
        for(int i=0;i<=N;i++) {
            collection[i] = i;
        }

        // N개의 도시 연결 정보
        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                // isContain: 1이면 i번과 j번이 연결 O, 0이면 연결 X
                int isContain = Integer.parseInt(st.nextToken());
                if (isContain == 1 && find(i) != find(j)) {
                    union(i, j);
                }
            }
        }

        // M개의 가고 싶은 나라 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isTripPossible = true;
        int country = Integer.parseInt(st.nextToken());
        for(int i=0;i<M-1;i++) {
            int gotoCountry = Integer.parseInt(st.nextToken());
            if(find(country) != find(gotoCountry)) {
                isTripPossible = false;
                break;
            }
        }

        // 만약 isTripPossible가 true면 모두 여행 가능, 아니면 불가능
        if(isTripPossible)
            bw.write("YES");
        else
            bw.write("NO");
        bw.flush();
        bw.close();
    }

    public static void union(int a, int b) {
        int firstA = a, firstB = b;

        // a가 집합 대표가 아닐 경우 (a와 collection[a]가 동일 하지 않을 경우)
        if(a != collection[a])
            firstA = find(a); //  a 집합 대표 찾기 ( find(a) )


        // b가 집합 대표가 아닐 경우 (b와 collection[b]가 동일 하지 않을 경우)
        if(b != collection[b])
            firstB = find(b); //  b 집합 대표 찾기 ( find(b) )

        // b 집합의 대표를 a 집합의 대표로
        collection[firstB] = firstA;
    }

    public static int find(int a) {
        // a가 집합 대표일 경우 (a와 collection[a]가 동일 할 경우)
        if (a == collection[a])
            return a;

        //  a가 집합 대표가 아닐 경우
        collection[a] = find(collection[a]);
        return collection[a];
    }
}