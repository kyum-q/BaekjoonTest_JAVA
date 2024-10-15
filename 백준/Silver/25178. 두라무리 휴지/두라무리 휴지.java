import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();

        Map<Character, Boolean> characters = Map.of('a', true, 'e', true, 'i', true, 'o', true, 'u', true);

        String result = "YES";
        if (!check(first, second, length, 0) || !check(first, second, length, length - 1)) {
            result = "NO";
        }

        String newFirst = "";
        String newSecond = "";
        for (int i = 0; i < length; i++) {
            char f = first[i];
            char s = second[i];
            if (characters.get(f) == null) {
                newFirst += f;
            }
            if (characters.get(s) == null) {
                newSecond += s;
            }
        }

        Arrays.sort(first);
        Arrays.sort(second);

        if (!Arrays.equals(first, second) || !newFirst.equals(newSecond)) {
            result = "NO";
        }
        bw.write(result);
        bw.flush();
        bw.close();
    }

    private static boolean check(char[] first, char[] second, int length, int i) {
        char f = first[i];
        char s = second[i];
        if (i == 0 || i == length - 1) {
            if (f != s) {
                return false;
            }
        }
        return true;
    }
}
