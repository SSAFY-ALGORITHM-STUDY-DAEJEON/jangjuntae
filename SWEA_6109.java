import java.util.*;
import java.io.*;

class Solution{
    static int n;
    static int game[][];

    static void UP(){
        for(int j = 0; j < n ; j++){
            for(int i = 0; i < n - 1; i++){
                if(game[i][j] != 0){
                    int k = i + 1;
                    while(k < n) {
                        if(game[i][j] == game[k][j]) {
                            game[i][j] *= 2;
                            game[k][j] = 0;
                            break;
                        }
                        else if(game[k][j] != 0){
                            break;
                        }
                        k++;
                    }
                }
            }
        }
        for(int j = 0; j < n ; j++){
            for(int i = 0; i < n - 1; i++){
                if(game[i][j] == 0){
                    for(int k = i + 1; k < n; k++){
                        if(game[k][j] != 0){
                            game[i][j] = game[k][j];
                            game[k][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    static void DOWN(){
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 1; j--){
                if(game[j][i] != 0){
                    int k = j - 1;
                    while(k >= 0) {
                        if(game[j][i] == game[k][i]) {
                            game[j][i] *= 2;
                            game[k][i] = 0;
                            break;
                        }
                        else if(game[k][i] != 0){
                            break;
                        }
                        k--;
                    }
                }
            }
        }
        for(int j = n - 1; j >= 0 ; j--){
            for(int i = n - 1; i >= 1; i--){
                if(game[i][j] == 0){
                    for(int k = i - 1; k >= 0; k--){
                        if(game[k][j] != 0){
                            game[i][j] = game[k][j];
                            game[k][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    static void RIGHT(){
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 1; j--){
                if(game[i][j] != 0){
                    int k = j - 1;
                    while(k >= 0) {
                        if(game[i][j] == game[i][k]) {
                            game[i][j] *= 2;
                            game[i][k] = 0;
                            break;
                        }
                        else if(game[i][k] != 0){
                            break;
                        }
                        k--;
                    }
                }
            }
        }
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 1; j--){
                if(game[i][j] == 0){
                    for(int k = j - 1; k >= 0; k--){
                        if(game[i][k] != 0){
                            game[i][j] = game[i][k];
                            game[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    static void LEFT(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                if(game[i][j] != 0){
                    int k = j + 1;
                    while(k < n) {
                        if(game[i][j] == game[i][k]) {
                            game[i][j] *= 2;
                            game[i][k] = 0;
                            break;
                        }
                        else if(game[i][k] != 0){
                            break;
                        }
                        k++;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (game[i][j] == 0) {
                    for (int k = j + 1; k < n; k++) {
                        if (game[i][k] != 0) {
                            game[i][j] = game[i][k];
                            game[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            game = new int[n][n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    game[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if(dir.equals("up")){
                UP();
            }
            else if(dir.equals("down")){
                DOWN();
            }
            else if(dir.equals("right")){
                RIGHT();
            }
            else if(dir.equals("left")){
                LEFT();
            }

            System.out.println("#" + t);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(game[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
