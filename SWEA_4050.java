import java.io.*;
import java.util.*;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 
		 int T = Integer.parseInt(br.readLine());
		 
		 for(int t = 1; t <= T; t++) {
			 int n = Integer.parseInt(br.readLine());
			 
			 PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			 
			 st = new StringTokenizer(br.readLine());
			 
			 for(int i = 0; i < n; i++) {
				 pq.offer(Integer.parseInt(st.nextToken()));
			 }
			 
			 int answer = 0;
			 
			 while(pq.size() > 2) {
				 answer += pq.poll();
				 answer += pq.poll();
				 pq.poll();
			 }
			 
			 while(!pq.isEmpty()) {
				 answer += pq.poll();
			 }
			 
			 System.out.println("#" + t + " " + answer);
		 }
	}
}
