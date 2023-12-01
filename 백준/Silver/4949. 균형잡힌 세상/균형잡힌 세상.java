import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();

            if(s.equals(".")) break;

            Deque<Character> lastPl = new LinkedList<>();

            boolean isStringCheck = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                char check = ' ';
                switch (c) {
                    case '[':
                    case '(':
                        lastPl.add(c);
                        break;
                    case ']':
                        check = '[';
                        break;
                    case ')':
                        check = '(';
                        break;
                }

                if(check != ' ' && (lastPl.isEmpty() || lastPl.pollLast() != check)) {
                    isStringCheck = false;
                }

                if(!isStringCheck)
                    break;
            }
            if(isStringCheck && lastPl.isEmpty() && s.charAt(s.length()-1) == '.') {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }

    }
}