import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int n = Integer.parseInt(br.readLine());

            char[] arr = new char[n];

            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().charAt(0);
            }

            int left = 0;
            int right = n - 1;

            StringBuilder sb = new StringBuilder("#" + tc + " ");

            while (left <= right) {
                int l = left;
                int r = right;

                boolean valid = true;

                while (l <= r) {
                    if (arr[l] < arr[r]) {
                        break;
                    }

                    if (arr[l] > arr[r]) {
                        valid = false;
                        break;
                    }

                    l++;
                    r--;
                }

                if (valid) {
                    sb.append(arr[left++]);
                }
                else {
                    sb.append(arr[right--]);
                }
            }

            System.out.println(sb);
        }
    }
}
