import java.io.*;
import java.util.*;

public class Main
{
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            char[][] board = new char[n][n];

            int k = n / 2;

            board[k][k] = 'W';
            board[k - 1][k] = 'B';
            board[k - 1][k - 1] = 'W';
            board[k][k - 1] = 'B';

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int dol = Integer.parseInt(st.nextToken());

                if(dol == 1){
                    board[x][y] = 'B';
                    for(int d = 0; d < 8; d++){
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                            continue;
                        }

                        if(board[nx][ny] == 'W'){
                            boolean check = false;
                            while(board[nx][ny] != 'B' && board[nx][ny] != '\0'){
                                nx = nx + dx[d];
                                ny = ny + dy[d];

                                if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                                    break;
                                }

                                if(board[nx][ny] == 'B'){
                                    check = true;
                                }
                            }
                            if(check){
                                nx = x + dx[d];
                                ny = y + dy[d];

                                while(board[nx][ny] != 'B'){
                                    board[nx][ny] = 'B';
                                    nx = nx + dx[d];
                                    ny = ny + dy[d];

                                    if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                else{
                    board[x][y] = 'W';
                    for(int d = 0; d < 8; d++){
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                            continue;
                        }

                        if(board[nx][ny] == 'B'){
                            boolean check = false;
                            while(board[nx][ny] != 'W' && board[nx][ny] != '\0'){
                                nx = nx + dx[d];
                                ny = ny + dy[d];

                                if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                                    break;
                                }

                                if(board[nx][ny] == 'W'){
                                    check = true;
                                }
                            }
                            if(check){
                                nx = x + dx[d];
                                ny = y + dy[d];

                                while(board[nx][ny] != 'W'){
                                    board[nx][ny] = 'W';
                                    nx = nx + dx[d];
                                    ny = ny + dy[d];

                                    if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            int black = 0;
            int white = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 'B'){
                        black++;
                    }
                    else if(board[i][j] == 'W'){
                        white++;
                    }
                }
            }

            System.out.println("#" + t + " " + black + " " + white);
        }
    }
}
