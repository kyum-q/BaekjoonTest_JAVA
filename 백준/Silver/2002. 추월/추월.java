import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String [] first = new String[N];
        for (int i = 0; i < N; i++) {
            first[i] = br.readLine();
        }

        String [] end = new String[N];
        for (int i = 0; i < N; i++) {
            end[i] = br.readLine();
        }

        Map<String, Boolean> goCar = new HashMap<>();

        int count = 0;
        int sIndex = 0, eIndex = 0;
        while(eIndex < N && sIndex < N) {
            if(first[sIndex].equals(end[eIndex])) {
                sIndex++;
                eIndex++;
            }
            else if(goCar.containsKey(first[sIndex])) {
                sIndex++;
            }
            else {
                count++;
                goCar.put(end[eIndex], true);
                eIndex++;
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
    }
}