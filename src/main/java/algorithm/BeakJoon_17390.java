package algorithm;

import java.io.*;
import java.util.Arrays;


public class BeakJoon_17390 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int q = Integer.parseInt(s1[1]);

        int[] array = new int[n];
        int[] sum = new int[n];
        String[] s2 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(array);

        sum[0] = array[0];
        for(int i=1; i<n; i++){
            sum[i] = sum[i-1] + array[i];
        }

        for(int i=0; i<q; i++){
            String[] s3 = br.readLine().split(" ");
            int result = sum[Integer.parseInt(s3[1])-1] - sum[Integer.parseInt(s3[0])-1] + array[Integer.parseInt(s3[0])-1];
            bw.write(result +"\n");
        }

        bw.flush();
    }
}
