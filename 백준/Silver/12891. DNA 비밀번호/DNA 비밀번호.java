import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String [] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // S,P 입력
        String [] sp = br.readLine().split(" ");
        int S = Integer.parseInt(sp[0]);
        int P = Integer.parseInt(sp[1]);

        // DNA 문자열 입력
        String DNAString = br.readLine();

        // DNA 최소 문자 개수
        String [] minDNA = br.readLine().split(" ");
        int aMinCount = Integer.parseInt(minDNA[0]);
        int cMinCount = Integer.parseInt(minDNA[1]);
        int gMinCount = Integer.parseInt(minDNA[2]);
        int tMinCount = Integer.parseInt(minDNA[3]);

        // 0~P까지 DNA 개수 구하기
        int aCount = 0, cCount = 0, gCount = 0, tCount = 0;

        for(int i=0;i<P;i++) {
            switch (DNAString.charAt(i)) {
                case 'A': aCount++; break;
                case 'C': cCount++; break;
                case 'G': gCount++; break;
                case 'T': tCount++; break;
            }
        }

        // DNA 비밀번호 가능한 개수
        int count = 0;

        // 포인터 선언
        int start = 0;
        int end = P-1;

        while(end <= S-1) {
            if(aCount >= aMinCount && cCount >= cMinCount
            && gCount >= gMinCount && tCount >= tMinCount) {
//                System.out.println(start + "|" + end);
                count ++;
            }
            switch (DNAString.charAt(start)) {
                case 'A': aCount--; break;
                case 'C': cCount--; break;
                case 'G': gCount--; break;
                case 'T': tCount--; break;
            }
            start++;

            end++;
            if(end == S)
                break;
            switch (DNAString.charAt(end)) {
                case 'A': aCount++; break;
                case 'C': cCount++; break;
                case 'G': gCount++; break;
                case 'T': tCount++; break;
            }
        }

        System.out.println(count);
    }
}