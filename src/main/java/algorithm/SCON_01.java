package algorithm;

import java.io.*;

public class SCON_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);

        int[] array = new int[n];
        String[] s2 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(s2[i]);
        }

        int stress = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            int current = array[i];

            stress = Integer.max(0, stress + current);
            if(stress >= m)
                count++;
        }

        System.out.println(count);
    }
}