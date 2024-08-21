package algorithm;

import java.io.*;

public class BeakJoon_3067 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];

            String[] s2 = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                coins[j] = Integer.parseInt(s2[j]);
            }
            int price = Integer.parseInt(br.readLine());

            int[] dp = new int[price+1];
            dp[0] = 1;

            for(int j=0; j<n; j++){
                int coin = coins[j];
                for(int k=coin; k<=price; k++){
                    dp[k] += dp[k-coin];
                }
            }

            System.out.println(dp[price]);
        }

    }
}