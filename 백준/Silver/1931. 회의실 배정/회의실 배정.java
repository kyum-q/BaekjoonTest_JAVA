import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 수 입력
        ArrayList<Meeting> meetings = new ArrayList<>();

        // 회의 입력
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startClock = Integer.parseInt(st.nextToken());
            int endClock = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(startClock, endClock));
        }

        // 정렬
        Collections.sort(meetings, new MeetingComparator());

        int count = 0;

        // 현재 확인할 회의가 더이상 없을 때까지
        int i = 0;
        while(i < N) {
            // 얻어내고 count 증가
            Meeting m = meetings.get(i++);
            count++;

            // 현재 확인할 회의가 더이상 없을 때까지
            while (i<N){
                // 방금 index 회의의 start 시간이 앞서 뽑아낸 회의의 end 시간보다 같거나 클 때까지
                Meeting newM = meetings.get(i);
                if(m.end <= newM.start) {
                    break;
                }
                i++;
            }
        }

        System.out.println(count);
    }

    public static class MeetingComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            if(o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        }
    }

    public static class Meeting {
        public int start;
        public int end;
        public int clock;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
            this.clock = end - start;
        }
    }
}