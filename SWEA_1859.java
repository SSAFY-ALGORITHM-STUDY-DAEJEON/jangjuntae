import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(br.readLine());

            int[] arr = new int[k];

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < k; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            int max = arr[k - 1];

            for(int j = k - 2; j >= 0; j--){
                if(arr[j] < max){
                    result += (long)max - arr[j];
                }
                else{
                    max = arr[j];
                }
            }

            int num = i + 1;

            System.out.println("#" + num + " " + result);
        }
    }
}
