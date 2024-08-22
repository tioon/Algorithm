package algorithm;

import java.io.*;
import java.util.Arrays;

public class BeakJoon_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] s1 = br.readLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);

            String[] s2 = br.readLine().split(" ");
            int[] a = new int[n];
            for(int j=0; j<n; j++){
                a[j] = Integer.parseInt(s2[j]);
            }
            String[] s3 = br.readLine().split(" ");
            int[] b = new int[m];
            for(int j=0; j<m; j++){
                b[j] = Integer.parseInt(s3[j]);
            }

            Arrays.sort(a);
            Arrays.sort(b);


            int[] result = new int[n];
            int sum=0;
            int count=0;
            for(int j=0; j<n; j++){
                for(int k=count; k<m; k++){
                    if(a[j] > b[k]){
                        //System.out.println(a[j]+" "+b[k]);
                        count++;
                    } else break;
                }
                result[j]+=count;
                sum+=result[j];
                //System.out.println(j+" "+result[j]);
            }

            System.out.println(sum);


        }
    }
}