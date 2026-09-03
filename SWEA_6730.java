import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int k = 0;
			
			int up = 0;
			int down = 0;
			
			while(k < n - 1) {
				if(arr[k] < arr[k + 1]) {
					up = Math.max(arr[k + 1] - arr[k], up);
				}
				else if(arr[k] > arr[k + 1]) {
					down = Math.max(arr[k] - arr[k + 1], down);
				}
				
				k++;
			}
			
			System.out.println("#" + t + " " + up + " " + down);
		}
	}
}
