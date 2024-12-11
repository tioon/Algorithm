package algorithmStudy.주차1;

import java.io.*;
import java.util.Arrays;

// 빵집 (1주차 1번문제)
public class BeakJoon_3109 {
    static int[] x = {-1,-1,-1};
    static int[] y = {-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        int r = Integer.parseInt(s1[0]);
        int c = Integer.parseInt(s1[1]);

        char[][] array = new char[r][c];
        int[][] value = new int[r][c];

        for(int i=0; i<r; i++){
            String[] s2 = br.readLine().split("");
            for(int j=0; j<c; j++) {
                array[i][j] = s2[j].charAt(0);
            }
        }

        for(int i=0; i<r; i++){
            if(array[0][i] == '.'){
                value[0][i] = 1;
            }
        }

        for(int i=1; i<r; i++){
            for(int j=c-1; j>=0; j--){

            }
        }
    }
}