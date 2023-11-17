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
	public static boolean [][] isVisted;
	public static ArrayList<Integer> results = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] nums = new int [N+2][N+2];
		for(int i=1;i<=N;i++) {
			String s = br.readLine();
			for (int j = 1; j <= N; j++) {
				nums[i][j] = (int)(s.charAt(j-1) - '0');
			}
		}
		
		isVisted = new boolean [N+2][N+2];
		
		for(int i=1;i<=N;i++) { 
			for (int j = 1; j <= N; j++) {
				if(nums[i][j] == 1 && !isVisted[i][j]) {
					int result = BFS(nums, i, j);
					results.add(result);
				}
			}
		}
		
		Collections.sort(results);
		
		System.out.println(results.size());
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}
	}
	
	public static int BFS(int [][] nums, int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		
		int [] dx = {1, 0, -1, 0};
		int [] dy = {0, 1, 0, -1};
		
		queue.add(new Node(x, y));
		isVisted[x][y] = true; 
		int sum = 1;
		
		while(!queue.isEmpty()) {
			Node value = queue.poll();
			
			int newX = value.x;
			int newY = value.y;
			
			for(int i=0;i<4;i++) {
				if(nums[newX+dx[i]][newY+dy[i]] == 1 && !isVisted[newX+dx[i]][newY+dy[i]]) {
					sum++;
					queue.add(new Node(newX+dx[i], newY+dy[i]));
					isVisted[newX+dx[i]][newY+dy[i]] = true;
				}
			}
		}
		
		return sum;
	}
	
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x =x;
			this.y =y;
		}
	}
}
