package algorithm;

import java.io.*;

public class BeakJoon_14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");

        int n = Integer.parseInt(s1[0]); // 문제 수
        int t = Integer.parseInt(s1[1]); // 시간

        int[] dp = new int[t+1];

        for(int i=0; i<n; i++){
            String[] s2 = br.readLine().split(" ");
            int studyTime = Integer.parseInt(s2[0]);
            int score = Integer.parseInt(s2[1]);

            for(int j=t; j>=studyTime; j--){
                dp[j] = Math.max(dp[j], dp[j-studyTime]+score);
            }
        }

        int max = 0;
        for(int i=0; i<=t; i++){
            if(dp[i] > max)
                max = dp[i];
        }
        System.out.println(max);
    }
}