import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static int N;
    public static boolean [] diagonal1, diagonal2;
    public static boolean [] row, col;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        diagonal1 = new boolean[N*2-1];
        diagonal2 = new boolean[N*2-1];
        row = new boolean[N];
        col = new boolean[N];

        long result = 0;
        
        row[0] = true;
        for(int j=0;j<N;j++) {
            col[j] = true;
            diagonal1[j] = true;
            diagonal2[-j+N-1] = true;
            result += DFS(0, j, 1);
            col[j] = false;            
            diagonal1[j] = false;
            diagonal2[-j+N-1] = false;
        }

        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
 
    public static int DFS(int x, int y, int count) {
        if(count == N)
            return 1;
        
        int result = 0;

        int i = x+1;
        row[i] = true;
        for(int j=0;j<N;j++) {
            if(col[j]) continue;
            if(checkRoundQ(i,j)) {
                col[j] = true;
                diagonal1[i+j] = true;
                diagonal2[i-j+(N-1)] = true;
                result += DFS(i,j, count+1);
                col[j] = false;
                diagonal1[i+j] = false;
                diagonal2[i-j+(N-1)] = false;
            }
        }
        row[i] = false;
        
        return result;
    }

    public static boolean checkRoundQ(int x, int y) {
        if(diagonal1[x+y]) return false;
        if(diagonal2[x-y+(N-1)]) return false;
        
        return true;
    }
}