import java.io.*;
import java.util.*;

public class Main {
    public static int [] collection;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // n,m 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개의 집합 생성
        collection = new int [N+1];
        for(int i=0;i<=N;i++) {
            collection[i] = i;
        }

        // M개의 연산 실행
        for(int i=0;i<M;i++) {
            // 연산 종류(0: union, 1: find) a b 입력
            st = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // operator가 0 일 때 : a,b 집합 합치기 : a,b union
            if(operator == 0) {
                union(a, b);
            }

            // operator가 1 일 때 : a와 b가 같은 그룹인지 확인 : find
            if(operator == 1) {
                if (find(a) == find(b))
                    bw.write("YES\n"); // 같은 그룹일 경우 yes 출력
                else
                    bw.write("NO\n");  // 아닐 경우 no 출력
            }
        }
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