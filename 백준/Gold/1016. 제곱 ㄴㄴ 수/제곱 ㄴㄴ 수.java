import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long min = sc.nextLong();
        long max = sc.nextLong();
        int range = (int) (max - min + 1);

        boolean[] isSquareFree = new boolean[range];
        for (int i = 0; i < range; i++) {
            isSquareFree[i] = true;
        }

        for (long i = 2; i * i <= max; i++) {
            long start = (min / (i * i)) * (i * i);
            if (start < min) {
                start += i * i;
            }

            for (long j = start; j <= max; j += i * i) {
                isSquareFree[(int) (j - min)] = false;
            }
        }

        int count = 0;
        for (int i = 0; i < range; i++) {
            if (isSquareFree[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
