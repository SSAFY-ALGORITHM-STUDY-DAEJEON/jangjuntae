import java.util.*;
import java.io.*;

class Solution{
	static int w;
	static int h;
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int x;
	static int y;
	static int d;
	
	static void up() {
		map[x][y] = '^';
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if(nx < 0 || nx >= h || ny <0 || ny >= w) {
			return;
		}
		
		if(map[nx][ny] == '.') {
			map[x][y] = '.';
			map[nx][ny] = '^';
			x = nx;
			y = ny;
		}
	}
	
	static void down() {
		map[x][y] = 'v';
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if(nx < 0 || nx >= h || ny <0 || ny >= w) {
			return;
		}
		
		if(map[nx][ny] == '.') {
			map[x][y] = '.';
			map[nx][ny] = 'v';
			x = nx;
			y = ny;
		}
	}
	
	static void left() {
		map[x][y] = '<';
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if(nx < 0 || nx >= h || ny <0 || ny >= w) {
			return;
		}
		
		if(map[nx][ny] == '.') {
			map[x][y] = '.';
			map[nx][ny] = '<';
			x = nx;
			y = ny;
		}
	}
	
	static void right() {
		map[x][y] = '>';
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if(nx < 0 || nx >= h || ny < 0 || ny >= w) {
			return;
		}
		
		if(map[nx][ny] == '.') {
			map[x][y] = '.';
			map[nx][ny] = '>';
			x = nx;
			y = ny;
		}
	}
	
	static void shoot() {
		int nx = x;
		int ny = y;
		while(nx + dx[d] >= 0 && nx + dx[d] < h && ny + dy[d] >= 0 && ny + dy[d] < w) {
			nx = nx + dx[d];
			ny = ny + dy[d];
			if(map[nx][ny] == '*') {
				map[nx][ny] = '.';
				return;
			}
			else if(map[nx][ny] == '#'){
				return;
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
			for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			String str;
			char c;
			
			for(int i = 0; i < h; i++) {
				str = br.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					
					if(map[i][j] == '^') {
						x = i;
						y = j;
						d = 0;
					}
					else if(map[i][j] == 'v'){
						x = i;
						y = j;
						d = 1;
					}
					else if(map[i][j] == '<'){
						x = i;
						y = j;
						d = 2;
					}
					else if(map[i][j] == '>'){
						x = i;
						y = j;
						d = 3;
					}
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			
			String move = br.readLine();
			
			for(int i = 0; i < n; i++) {
				c = move.charAt(i);
				
				if(c == 'U') {
					d = 0;
					up();
				}
				else if(c =='D') {
					d = 1;
					down();
				}
				else if(c =='L') {
					d = 2;
					left();
				}
				else if(c =='R') {
					d = 3;
					right();
				}
				else if(c == 'S'){
					shoot();
				}
			}
			
			System.out.print("#" + t + " ");
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
