import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        SortString [] s = new SortString[N];
        for (int i = 0; i < N; i++) {
            s[i] = new SortString(br.readLine());
        }

        Arrays.sort(s);

        String check = "";
        for (int i = 0; i < N; i++) {
            if(!check.equals(s[i].s)) {
                System.out.println(s[i]);
                check = s[i].s;
            }
        }
    }

    public static class SortString implements Comparable<SortString> {

        String s;
        public SortString(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }

        @Override
        public int compareTo(SortString sort) {
            String s2 = sort.s;
            if(s.length() == s2.length()) {
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i) > s2.charAt(i)) {
                        return 1;
                    }
                    else if(s.charAt(i) < s2.charAt(i)) {
                        return -1;
                    }
                }
            }
            return s.length() - s2.length();
        }
    }
}