package algorithm;

import java.io.*;

public class BeakJoon_10164 {
    static int n; // 행 (세로)
    static int m; // 열 (가로)
    static int k; // 중간값
    static int[][] array;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        k = Integer.parseInt(s1[2]);
        array = new int[n+1][m+1];

        int y = k/m+1;
        int x = k%m;

        if(k ==0){
            result = dfs(1,1,n,m);
        }
        else{
            int before = dfs(1,1,y,x);
            int after = dfs(y,x,n,m);
            result = before * after;
        }

        System.out.println(result);
    }

    public static int dfs(int startY, int startX, int destinationY, int destinationX){
        int[] pX = {1,0};
        int[] pY = {0,1};

        if(startY == destinationY && startX == destinationX) {
            return 1;
        }

        int count=0;

        for(int i=0; i<2; i++){
            int nextX = startX+pX[i];
            int nextY = startY+pY[i];

            if(nextX<=destinationX && nextY<=destinationY){
                count += dfs(nextY, nextX, destinationY, destinationX);
            }
        }
        return count;
    }
}