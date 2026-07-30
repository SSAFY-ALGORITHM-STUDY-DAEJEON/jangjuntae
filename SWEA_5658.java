import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Queue<Character> queue = new ArrayDeque<>();
            HashSet<Integer> hashSet = new HashSet<>();
            String str = br.readLine();
            int slice = n / 4;

            for(int i = 0; i < n; i++){
                queue.add(str.charAt(i));
            }

            for(int i = 0; i < slice; i++){
                for(int x = 0; x < n; x += slice) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = x; j < x + slice; j++) {
                        sb.append(queue.peek());
                        queue.offer(queue.poll());
                    }
                    hashSet.add(Integer.parseInt(sb.toString(), 16));
                }
                queue.offer(queue.poll());
            }

            ArrayList list = new ArrayList<>(hashSet.size());

            int i = 0;
            for(int num : hashSet){
                list.add(num);
                i++;
            }
            Collections.sort(list, Collections.reverseOrder());

            System.out.println("#" + t + " " + list.get(k - 1));
        }
    }
}
