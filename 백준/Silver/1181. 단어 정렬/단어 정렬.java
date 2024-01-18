import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        TreeSet<Word> words = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            words.add(new Word(br.readLine()));
        }

        for(Word w : words) {
            bw.write(w.s + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static class Word implements Comparable<Word> {
        String s;
        int len;

        public Word(String s) {
            this.s = s;
            len = s.length();
        }

        @Override
        public int compareTo(Word o) {
            if(len == o.len) {
                return s.compareTo(o.s);
            }
            return  len - o.len;
        }
    }

}