package algorithm;

import java.io.*;

public class BeakJoon_11170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] dp = new int [1000001];
        dp[0] = 1;

        for(int i=1; i<1000001; i++){
            int num = i;
            int count=0;

            while(num != 0){
                if(num%10 == 0){
                    count++;
                }
                num/=10;
            }

            if(count != 0)
                dp[i] = dp[i-1]+count;
            else
                dp[i] = dp[i-1];
        }

        for(int i=0; i<T; i++){
            String[] s1 = br.readLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);

            if(n == 0)
                bw.write(Integer.toString(dp[m])+'\n');
            else
                bw.write(Integer.toString(dp[m] - dp[n-1])+'\n');
        }

        bw.flush();
    }
}