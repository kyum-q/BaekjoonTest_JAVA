import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 문자열 길이 S와 부분문자열 길이 P 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		// DNA 문자열 입력
		st = new StringTokenizer(br.readLine());
		String DNA = st.nextToken();
		
		// 부분 문자열에 필요한 DNA에 구성 입력 
		st = new StringTokenizer(br.readLine());
		Long essential [] = new Long[4];
		for(int i=0;i<4;i++) {
			essential[i] = Long.parseLong(st.nextToken());
		}
		
		// 부분 문자열에 존재하는 DNA에 구성
		Long existence [] = new Long[4];
		for(int i=0;i<4;i++) {
			existence[i] = new Long(0);
		}
		
		// index 0 ~ P-1까지 DNA의 각 구성 개수 구하기
		for(int i=0;i<P;i++) {
			int index = getDNAConfigurationIndex(DNA.charAt(i));
			existence[index]++;
		}
		
		// 필요한 index (start, end) | 사용가능한 비밀 번호 개수 (count) 
		int start = 0, end = P-1, count = 0;
		
		// index end가 S(문자열 길이)가 될 때까지 반복 조사
		while(end<S) {
			// 필수 성분을 다 갖췄는지 확인 -> count++ 
			int check = 0;
			for(check=0;check<=4;check++) {
				if(check==4)
					break;
				if(essential[check]>existence[check])
					break;
			}
			if(check==4)
				count++;
			
			// start에 있는 성분을 existence 배열에서 제거
			int index = getDNAConfigurationIndex(DNA.charAt(start++));
			existence[index]--;
			
			// end가 마지막일 때 미리 대비해 break
			if(end+1 == S)
				break;
			
			// end에 있는 성분을 existence 배열에서 추가
			index = getDNAConfigurationIndex(DNA.charAt(++end));
			existence[index]++;
			
			
		}
		System.out.println(count);
	}
	
	// DNA 구성에 따른 index 정보를 알려주는 함수
	public static int getDNAConfigurationIndex(char c) {
		switch(c) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		}
		return -1;
	}
}
