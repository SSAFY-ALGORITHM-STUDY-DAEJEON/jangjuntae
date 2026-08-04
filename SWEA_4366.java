import java.io.*;
import java.util.*;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int T = Integer.parseInt(br.readLine());
		 
		 for(int t = 1; t <= T; t++) {
			 String str = br.readLine();
			 StringBuilder binary = new StringBuilder(str);
			 str = br.readLine();
			 StringBuilder ternary = new StringBuilder(str);
			 
			 HashSet<Integer> set = new HashSet<>();
			 
			 for(int i = 0; i < binary.length(); i++) {
				 char origin = binary.charAt(i);
				 for(int j = 0; j < 2; j++) {
					 binary.setCharAt(i, (char)(j + '0'));
					 set.add(Integer.parseInt(binary.toString(), 2));
				 }
				 binary.setCharAt(i, origin);
			 }
			 
			 loop:
				 for(int i = 0; i < ternary.length(); i++) {
					 char origin = ternary.charAt(i);
					 for(int j = 0; j < 3; j++) {
						 ternary.setCharAt(i, (char)(j + '0'));
						 int k = Integer.parseInt(ternary.toString(), 3);
						 if(set.contains(k)){
							 System.out.println("#" + t + " " + k);
							 break loop;
						 }
					 }
					 ternary.setCharAt(i, origin);
				 }
		 }
	}
}
