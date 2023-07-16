import java.io.*;
import java.util.Scanner;

public class Main {
   public static void main (String [] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       // N 입력
       int N = sc.nextInt();

       int [] score = new int[N];
       double maxScore = 0;
       for(int i=0;i<N;i++) {
           // 실제 성적 입력
           score[i] = sc.nextInt();
           // 최고점 알아내기
           if(maxScore < score[i])
               maxScore = score[i];
       }

       // 점수 재계산 및 합치기
       double sum = 0;
       for(int i=0;i<N;i++) {
           sum += score[i]/maxScore * 100.0;
       }

       // 평균 구하고 출력
       System.out.println(sum/N);
   }
}