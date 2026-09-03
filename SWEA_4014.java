import java.io.*;
import java.util.*;

class Solution{

    static boolean check(int[] arr, int n, int x) {
        boolean[] used = new boolean[n];

        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];

            if (diff == 0) {
                continue;
            }

            if (Math.abs(diff) > 1) {
                return false;
            }

            if (diff == -1) {
                for (int j = i; j < i + x; j++) {
                    if (j >= n) {
                        return false;
                    }

                    if (arr[j] != arr[i]) {
                        return false;
                    }

                    if (used[j]) {
                        return false;
                    }
                }

                for (int j = i; j < i + x; j++) {
                    used[j] = true;
                }
            }
            else {
                for (int j = i - 1; j >= i - x; j--) {
                    if (j < 0) {
                        return false;
                    }

                    if (arr[j] != arr[i - 1]) {
                        return false;
                    }

                    if (used[j]) {
                        return false;
                    }
                }

                for (int j = i - 1; j >= i - x; j--) {
                    used[j] = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {

                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for (int i = 0; i < n; i++) {

                int[] row = new int[n];
                int[] col = new int[n];

                for (int j = 0; j < n; j++) {
                    row[j] = map[i][j];
                    col[j] = map[j][i];
                }

                if (check(row, n, x)) {
                    answer++;
                }

                if (check(col, n, x)) {
                    answer++;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
