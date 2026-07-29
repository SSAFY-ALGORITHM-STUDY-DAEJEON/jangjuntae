import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] nums = new int[100];
            int sum = 0;

            for(int i = 0; i < 100; i++){
                nums[i] = Integer.parseInt(st.nextToken());
                sum += nums[i];
            }

            for(int i = 0; i < n; i++){
                Arrays.sort(nums);
                nums[0]++;
                nums[99]--;
            }

            Arrays.sort(nums);

            System.out.println("#" + t + " " + (nums[99] - nums[0]));
        }
    }
}
