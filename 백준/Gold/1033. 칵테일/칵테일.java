import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isCheckRatio; // 확인했는지 아는 변수
    static ArrayList<Ratio> [] ratios; // 비율 값을 알려주는 변수
    static long [] realRatio; // 실제 필요한 비율에 따른 최소 값 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 변수 초기화
        isCheckRatio = new boolean[N];
        ratios = new ArrayList[N];
        realRatio = new long[N];
        for(int i=0;i<N;i++) {
            ratios[i] = new ArrayList<>();
        }

        // (비율들의) 최소공배수
        long lcm = 1;
        // N-1개의 재료 조합 입력
        for(int i=0;i<N-1;i++) {
            // 각 재료의 비율 입력 (a의 질량 / b의 질량 = p/q)
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long p = Long.parseLong(st.nextToken());
            long q = Long.parseLong(st.nextToken());

            // 변수에 추가
            ratios[a].add(new Ratio(b, p, q));
            ratios[b].add(new Ratio(a, q, p));

            // 비율의 최소 공약수를 모두 곱한다.
            lcm *= (p * q / GCD(p,q));
        }

        // 실제 변수 값 초기화
        realRatio[0] = lcm;

        // DFS로 실제 값 구하기
        DFS(0);

        // 최대 공약수 구하기
        long mgcd = realRatio[0];
        for(int i=0;i<N;i++) {
            mgcd = GCD(mgcd, realRatio[i]);
        }

        // 출력
        for(int i=0;i<N;i++) {
            bw.write(realRatio[i]/mgcd + " ");
        }
        bw.flush();
        bw.close();
    }

    public static class Ratio {
        public int opponent;
        public long p;
        public long q;

        public Ratio(int opponent, long p, long q) {
            this.opponent = opponent;
            this.p = p;
            this.q = q;
        }
    }

    public static long GCD(long a, long b) {
        if(b == 0) return a;
        return GCD(b, a%b);
    }

    public static void DFS(int index) {
        isCheckRatio[index] = true;
        ArrayList<Ratio> ratio = ratios[index];
        for(int i=0;i<ratio.size();i++) {
            Ratio next = ratio.get(i);
            if(!isCheckRatio[next.opponent]) {
                realRatio[next.opponent] = realRatio[index] * next.q / next.p;
                DFS(next.opponent);
            }
        }
    }
}
