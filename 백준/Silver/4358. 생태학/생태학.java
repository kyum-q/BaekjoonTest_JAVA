import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

        ArrayList<String> input = new ArrayList<>();

        // 입력
        while(sc.hasNextLine()) {
            String s = sc.nextLine();

            if(s.isEmpty()) break;

            input.add(s);
        }

        // 정렬
        Collections.sort(input);

        // 나무 종류별로 수 세기
        ArrayList<Tree> trees = new ArrayList<>();
        trees.add(new Tree(input.get(0)));
        for(int j=1;j<input.size();j++) {
            if(input.get(j-1).equals(input.get(j))) {
                trees.get(trees.size()-1).count++;
            }
            else {
                trees.add(new Tree(input.get(j)));
            }
        }

        // 출력
        int N = input.size();
        for(int j=0;j<trees.size();j++) {
            Tree tree = trees.get(j);
            bw.write(tree.name + String.format(" %.4f", tree.getAvg(N)) +"\n");
        }
        bw.flush();
        bw.close();

    }

    public static class Tree {
        public double count = 1;
        public String name;
        public Tree(String name) {
            this.name = name;
        }

        // 평균 알아내기
        public double getAvg(int N) {
            return count / N * 100.0;
        }
    }
}