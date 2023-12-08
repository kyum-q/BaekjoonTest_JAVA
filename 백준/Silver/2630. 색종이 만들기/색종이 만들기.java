import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int [] counts;
    public static int [][] papers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        counts = new int[2];
        N = Integer.parseInt(br.readLine());

        papers = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        marge(0,0, N);

        bw.write(counts[0] + "\n" + counts[1]);

        bw.flush();
        bw.close();
    }

    public static void marge(int x, int y, int size) {
        if(size <= 0) return;

        int start = papers[x][y];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(papers[x+i][y+j] != start) {
                    marge(x,y,size/2);
                    marge(x,y + size/2, size/2);
                    marge(x + size/2, y, size/2);
                    marge(x + size/2,y + size/2, size/2);
                    return;
                }
            }
        }

        counts[start]++;
    }

    public static boolean isCheckRound(int i, int j) {
        return (i >=0 && j >= 0 && i < N && j < N);
    }
}