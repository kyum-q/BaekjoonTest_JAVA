import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BubbleSort [] A = new BubbleSort[N];
        for(int i=0;i<N;i++){
            // index와 값을 함께 저장
            A[i] = new BubbleSort(Integer.parseInt(br.readLine()), i);
        }

        // 정렬
        Arrays.sort(A);

        // 정렬되기까지 버블 정렬 횟수
        int maxValue = 0;
        for(int i=0; i<N; i++) {
            int preIndex = A[i].index;
            if (preIndex - i > maxValue) {
                maxValue = preIndex - i;
            }
        }

        System.out.println(maxValue + 1);
    }
}

// 값과 인덱스를 모두 담을 수 있는 클래스 (sort할때 비교가 가능하게 Comparable 인터페이스 구현)
class BubbleSort implements Comparable<BubbleSort> {
    int value;
    int index;

    BubbleSort(int value, int index) {
        this.value = value;
        this.index = index;
    }

    // 비교를 해주는 함수 (value의 값이 크면 배열 끝으로)
    @Override
    public int compareTo(BubbleSort b) {
        return this.value - b.value;
    }
}