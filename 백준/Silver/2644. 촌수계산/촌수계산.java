import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static boolean [] isVisted;
	public static ArrayList<Integer> [] lists;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		lists = new ArrayList [N+1];
		isVisted = new boolean[N+1];
		for (int i = 0; i < lists.length; i++) {
			lists[i]=new ArrayList<>(); 
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lists[a].add(b);
			lists[b].add(a);
		}
		
		System.out.println(BFS(start, end));
		
	}
	
	public static int BFS(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;
		
		queue.add(start);
		isVisted[start] = true;
		boolean isCheck = false;
		
		while(!queue.isEmpty() && !isCheck) {
			int size = queue.size();
			count++;
			for (int i = 0; i < size; i++) {
				int value = queue.poll();
				ArrayList<Integer> list = lists[value];
				for (int j = 0; j < list.size(); j++) {
					int newValue = list.get(j);
					if(!isVisted[newValue]) {
						queue.add(newValue);
						isVisted[newValue] = true;
						if(end == newValue) {
							isCheck = true;
							break;
						}
					}
				}
				if(isCheck) break;
			}
		}
		
		if(isCheck)
			return count;
		return -1;
	}
}
