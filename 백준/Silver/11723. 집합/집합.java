import java.io.*;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        TreeSet<String> lists = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            String [] s = br.readLine().split(" ");

            switch (s[0]) {
                case "add":
                        lists.add(s[1]);
                    break;
                case "remove":
                        lists.remove(s[1]);
                    break;
                case "check":
                    if(lists.contains(s[1]))
                        bw.write(1 + "\n");
                    else
                        bw.write(0 + "\n");
                    break;
                case "toggle":
                    if(lists.contains(s[1]))
                        lists.remove(s[1]);
                    else
                        lists.add(s[1]);
                    break;

                case "all":
                    lists.clear();
                    for (int j = 1; j <= 20; j++) {
                        lists.add(String.valueOf(j));
                    }
                    break;
                case "empty":
                    lists.clear();
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

}