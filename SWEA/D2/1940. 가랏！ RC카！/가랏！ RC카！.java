
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            int speed = 0;
            int result = 0;
            for (int i = 0; i < N; i++) {
                int command = sc.nextInt();
                switch (command) {
                    case 1:
                        speed += sc.nextInt();
                        break;
                    case 2:
                        speed -= sc.nextInt();
                        break;
                    default:
                        break;
                }
                if(speed < 0)
                    speed = 0;
                
                result += speed;
            }


            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}