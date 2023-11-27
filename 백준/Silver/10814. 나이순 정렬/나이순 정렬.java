import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Member [] members = new Member[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members[i] = new Member(age, name, i);
        }

        Arrays.sort(members);

        for (int i = 0; i < N; i++) {
            System.out.println(members[i]);
        }

    }

    public static class Member implements Comparable<Member> {

        int age;
        String name;
        int index;
        public Member(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }

        @Override
        public int compareTo(Member m) {
            if(age == m.age) {
                return index - m.index;
            }
            return age - m.age;
        }
    }
}