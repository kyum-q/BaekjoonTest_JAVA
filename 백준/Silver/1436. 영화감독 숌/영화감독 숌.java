import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = 0;
        String six = "666";
        for (int i = 0; i < N; i++) {
            int value = max + 1;
            String valueS = String.valueOf(value);
            while(!valueS.contains(six)) {
                value++;
                valueS = String.valueOf(value);
            }
            max = value;
        }

        System.out.println(max);
    }
}