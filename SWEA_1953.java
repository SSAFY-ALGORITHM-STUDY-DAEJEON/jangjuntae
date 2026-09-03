import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static int m;
	static int r;
	static int c;
	static int l;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int[] reverseDir = {1, 0, 3, 2};
	
	static boolean[][] pipe = {
			{false, false, false, false},
		    {true, true, true, true},    // 1번: 상, 하, 좌, 우
		    {true, true, false, false},   // 2번: 상, 하
		    {false, false, true, true},   // 3번: 좌, 우
		    {true, false, false, true},   // 4번: 상, 우
		    {false, true, false, true},   // 5번: 하, 우
		    {false, true, true, false},   // 6번: 하, 좌
		    {true, false, true, false}    // 7번: 상, 좌
	};
	
	static class Node{
		int x;
		int y;
		int time;
		
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r, c, 1));
		visited[r][c] = true;
		
		int count = 1;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			if(current.time >= l) {
				continue;
			}
			
			int currentPipe = map[current.x][current.y];
			
			for(int d = 0; d < 4; d++) {
				if(!pipe[currentPipe][d]) {
					continue;
				}
				
				int nx = current.x + dx[d];
				int ny = current.y + dy[d];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}
				
				int nextPipe = map[nx][ny];
				
				if(!pipe[nextPipe][reverseDir[d]]) {
					continue;
				}
				
				visited[nx][ny] = true;
				queue.add(new Node(nx, ny, current.time+1));
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken()); // 세로
			c = Integer.parseInt(st.nextToken()); // 가로
			l = Integer.parseInt(st.nextToken()); // 탈출 시간
			map = new int[n][m];
			visited = new boolean[n][m];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = bfs();
			
			System.out.println("#" + t + " " + result);
		}
	}
}
