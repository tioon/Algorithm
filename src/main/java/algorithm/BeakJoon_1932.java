package algorithm;

import java.io.*;


public class BeakJoon_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] array = new int[T];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<T; i++){
            array[i] = Integer.parseInt(br.readLine());
            if(max < array[i]-1)
                max = array[i]-1;
        }

        long[] DP = new long[max+1];


        for(int i=0; i<max+1; i++){
            if(i == 0)
                DP[i] = 1;
            else if(i == 1)
                DP[i] = 1;
            else if(i == 2)
                DP[i] = 1;
            else if(i == 3)
                DP[i] = 2;
            else if(i == 4)
                DP[i] = 2;
            else{
                DP[i] = DP[i-5] + DP[i-1];
            }
        }

        for(int i=0; i<T; i++)
            bw.write(Long.toString(DP[array[i]-1])+'\n');
        bw.flush();



    }
}
