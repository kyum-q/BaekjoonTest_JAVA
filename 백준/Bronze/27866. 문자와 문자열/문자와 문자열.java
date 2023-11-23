import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int index = Integer.parseInt(br.readLine());

        System.out.println(s.charAt(index-1));
    }
}
