import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Point [] points = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x,y);
        }

        Arrays.sort(points);

        for (int i = 0; i < N; i++) {
            System.out.println(points[i]);
        }

    }

    public static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if(y == p.y) {
                return x - p.x;
            }
            return y - p.y;
        }

        @Override
        public String toString() {
            return x + " " + y;
         }
    }
}