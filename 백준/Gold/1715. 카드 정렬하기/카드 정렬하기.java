import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 카드 묶음 입력
        PriorityQueue<Integer> cards = new PriorityQueue<>();

        for(int i=0;i<N;i++) {
            cards.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;

        while(cards.size() > 1) {
            int newCard = cards.poll() + cards.poll();
            count += newCard;
            cards.add(newCard);
        }

        System.out.println(count);
    }
}