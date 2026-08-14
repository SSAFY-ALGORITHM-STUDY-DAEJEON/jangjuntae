import java.io.*;
import java.util.*;

public class Main
{
	static int n;
	static int[][] cost;
	static int[][] dp;
	static final int INF = 1000000000;
	
	static int dfs(int visited, int now) {
		if(visited == (1 << n) - 1) {
			if (cost[now][0] == 0) {
		        return INF;
		    }
			
			return cost[now][0];
		}
		
		if(dp[visited][now] != -1) {
			return dp[visited][now];
		}
		
		int result = INF;
		
		for(int next = 0; next < n; next++) {
			if(((visited & (1 << next)) != 0) || (cost[now][next] == 0)) {
				continue;
			}
			
			int nextVisited = visited | (1 << next);
			int remainCost = dfs(nextVisited, next);
			
			if (remainCost == INF) {
	            continue;
	        }
			
			result = Math.min(result, cost[now][next] + dfs(nextVisited, next));
		}
		
		return dp[visited][now] = result;
	}
	
	public static void main(String args[]) throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 
		 n = Integer.parseInt(br.readLine().trim());
		 cost = new int[n][n];
		 dp = new int[1<<n][n];
		 
		 for(int i = 0; i < 1 << n; i++) {
			 Arrays.fill(dp[i], -1);
		 }
		 
		 for(int i = 0; i < n; i++) {
			 st = new StringTokenizer(br.readLine());
			 
			 for(int j = 0; j < n; j++) {
				 cost[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }
		 
		 int answer = dfs(1, 0);
		 
		 if(answer == INF) {
			 System.out.println(0);
			 return;
		 }
		 
		 System.out.println(answer);
	}
}
