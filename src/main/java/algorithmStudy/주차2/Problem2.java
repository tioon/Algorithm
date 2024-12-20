package algorithmStudy.주차2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

//백준 1212
public class Problem2 {
    static int[][] next = {{0,1}, {1,0}, {0,-1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = Integer.parseInt(br.readLine());

        int[][] array = new int[N][N];
        int number = N*N;

        int current=0;
        int x=0;
        int y=0;
        while(number>=1){
            array[y][x] = number--;

            //System.out.println(y+" "+x+" "+number);

            int nextX = x + next[current][0];
            int nextY = y + next[current][1];
            if(nextX>=0 && nextX<N && nextY>=0 && nextY<N && array[nextY][nextX] == 0){
                x = nextX;
                y = nextY;
            }
            else {
                current = (current+1)%4;
                x = x + next[current][0];
                y = y + next[current][1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write(array[i][j]+" ");
                if(array[i][j] == result){
                    sb.append((i+1)+" "+(j+1));
                }
            }
            bw.write('\n');
        }
        bw.write(sb.toString());
        bw.flush();

    }
}
