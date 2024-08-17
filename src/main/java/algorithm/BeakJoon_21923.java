package algorithm;

import java.io.*;


public class BeakJoon_21923 {
    static int n , m;
    static int max;
    static int [][] map;
    static int [][] dpUP, dpDown ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        max = -100000000;
        map = new int[n][m];
        dpUP = new int[n][m];
        dpDown = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s1[j]);
            }
        }

        br.close();

        dpUP[n-1][0] = map[n-1][0];
        for (int i = n-1; i >=0; i--) {
            if(i!=n-1) {
                dpUP[i][0] = dpUP[i+1][0] + map[i][0];
            }
            for (int j = 1; j < m; j++) {
                if(i!=n-1) {
                    dpUP[i][j] = Math.max(dpUP[i+1][j], dpUP[i][j-1])+ map[i][j];
                }
                else {
                    dpUP[i][j] =  dpUP[i][j-1] + map[i][j];
                }
            }
        }

        dpDown[n-1][m-1] = map[n-1][m-1];
        for (int i = n-1; i >=0; i--) {
            if(i!=n-1) {
                dpDown[i][m-1] = dpDown[i+1][m-1] + map[i][m-1];
            }
            for (int j = m-2; j >=0; j--) {
                if(i!=n-1) {
                    dpDown[i][j] = Math.max(dpDown[i+1][j], dpDown[i][j+1])+ map[i][j];
                }
                else {
                    dpDown[i][j] = dpDown[i][j+1] + map[i][j];
                }

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(dpDown[i][j]+ dpUP[i][j] , max);
            }
        }

        System.out.println(max);
    }
}