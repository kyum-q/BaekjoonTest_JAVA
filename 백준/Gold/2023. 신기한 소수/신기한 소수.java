import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());
        br.close();

        // 해당 자리수의 가장 작은 값
        int minNum = 1;
        for (int i = 1; i < N; i++) {
            minNum *= 10;
        }
        // 해당 자리수의 가장 큰 값 다음 값
        int maxNum = minNum * 10;

        // 현재 수
        int currentNum = minNum;

        while (currentNum < maxNum) {
            int[] Nnum = new int[N];
            Nnum[N - 1] = currentNum / minNum;

            // N번째 자리 수가 소수여야 함 (2,3,5,7)
            if (checkPrimeNumber(Nnum[N - 1])) {
                if (N >= 2) {
                    int checkNum = minNum / 10;

                    int i = N-2;
                    // 각 자리 수의 값 알아내기
                    while (i >= 0) {
                            Nnum[i] = currentNum % (checkNum * 10) / (checkNum);
                            int num = currentNum / checkNum;

                        // N 이전 자리 수는 1,3,7,9 이여야 하며, 이 수를 확인해서 소수 판변
//                        if (Nnum[i] == 1 || Nnum[i] == 3 || Nnum[i] == 7 || Nnum[i] == 9) {
                        if (!checkPrimeNumber(num)) {
                            currentNum = checkNum * (num + 1);
                            break;
                        }

                        checkNum /= 10;
                        i--;
                    }

                    if (i == -1) {
                        bw.write(currentNum + "\n");
                        currentNum++;
                    }

                    // 한자리 수일 경우, 해당 수가 소수이면 소수이므로 출력
                } else {
                    bw.write(currentNum + "\n");
                    currentNum++;
                }

            }
            // N번째 자리 수가 소수가 아니라면 해당 자리수 숫자 변경
            else {
                currentNum = minNum * (Nnum[N - 1] + 1);
            }
        }

        bw.flush();
        bw.close();
    }
    public static boolean checkPrimeNumber(int n) {
        if(n == 1) return false;
        for(int i=2;i<n-1;i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}