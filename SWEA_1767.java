import java.io.*;
import java.util.*;

public class Solution
{
	static int n;
	static int[][] board;
	static ArrayList<Node> list;
	static int maxCore;
	static int minWire;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void dfs(int idx, int coreCount, int wireLen) {
		if(idx == list.size()) {
			if(coreCount > maxCore) {
				maxCore = coreCount;
				minWire = wireLen;
			}
			else if(maxCore == coreCount) {
				minWire = Math.min(minWire, wireLen);
			}
			
			return;
		}
		
		int x = list.get(idx).x;
		int y = list.get(idx).y;
		
		for(int d = 0; d < 4; d++) {
			int nx = x;
			int ny = y;
			int count = 0;
			
			while(true) {
				nx += dx[d];
				ny += dy[d];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
					break;
				}
				
				if(board[nx][ny] != 0) {
					count = 0;
					break;
				}
				
				count++;
			}
			
			if(count > 0) {
				wireFill(x, y, count, d, 2);
				dfs(idx + 1, coreCount + 1, wireLen + count);
				wireFill(x, y, count, d, 0);
			}
		}
		
		dfs(idx + 1, coreCount, wireLen);
	}
	
	static void wireFill(int x, int y, int count, int d, int target) {
		int nx = x;
		int ny = y;
		
		for(int i = 0; i < count; i++) {
			nx += dx[d];
			ny += dy[d];
			board[nx][ny] = target;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			list = new ArrayList<>();
			maxCore = 0;
			minWire = 0;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					
					if(board[i][j] == 1) {
						if(i == 0 || j == 0 || i == n - 1 || j == n -1) {
							continue;
						}
						
						list.add(new Node(i, j));
					}
				}
			}
			
			dfs(0, 0, 0);
			
			System.out.println("#" + tc + " " + minWire);
		}
	}
}
