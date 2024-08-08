package algorithm;

import java.io.*;

public class BeakJoon_1923 {
    static int n;
    static int[][] array;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        array = new int[n][n];
        for(int i=0; i<n; i++){
            String[] s1 = br.readLine().split(" ");

            for(int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(s1[j]);
            }
        }

        divide(0,0,n);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int x, int y, int size){
        if (checkColor(x, y, size)) {
            if (array[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        divide(x, y, newSize); // 1사분면
        divide(x, y + newSize, newSize); // 2사분면
        divide(x + newSize, y, newSize); // 3사분면
        divide(x + newSize, y + newSize, newSize); // 4사분면
    }

    public static boolean checkColor(int x, int y, int size) {
        int color = array[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (array[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}