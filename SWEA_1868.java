import java.io.*;
import java.util.*;

public class Solution
{
	static int n;
	static char[][] map;
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[][] count;
	static boolean[][] visited;
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int d = 0; d < 8; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
					continue;
				}
				
				if(!visited[nx][ny] && map[nx][ny] != '*') {
					visited[nx][ny] = true;
					
					if(count[nx][ny] == 0) {
						queue.offer(new int[] {nx, ny});
					}
				}
			}
		}
		
		return;
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			count = new int[n][n];
			visited = new boolean[n][n];
			
			for(int i = 0; i < n; i++) {
				String str = br.readLine();
				for(int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int nx;
					int ny;
					
					if(map[i][j] == '.') {
						int cnt = 0;
						
						for(int d = 0; d < 8; d++) {
							nx = i + dx[d];
							ny = j + dy[d];
							
							if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
								continue;
							}
							
							if(map[nx][ny] == '*'){
								cnt++;
							}
						}
						
						count[i][j] = cnt;
					}
				}
			}
			
			int answer = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!visited[i][j] && map[i][j] == '.' && count[i][j] == 0) {
						answer++;
						bfs(i, j);
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!visited[i][j] && map[i][j] != '*') {
						answer++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
