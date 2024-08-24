package algorithm;

import java.io.*;

public class Beakjoon_14575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int t = Integer.parseInt(s1[1]);

        int[][] person = new int[n][2];
        int max = 0;

        for(int i=0; i<n; i++){
            String[] s2 = br.readLine().split(" ");
            person[i][0] = Integer.parseInt(s2[0]);
            person[i][1] = Integer.parseInt(s2[1]);

            if(max < person[i][1])
                max = person[i][1];
        }

        boolean[] dp = new boolean[max+1];

        for(int s=1;s <=max; s++){
            int low=0;
            int high=0;

            for(int j=0; j<n; j++){
                if(s < person[j][0]){
                    break;
                }

                low += person[j][0];
                high += Integer.min(s, person[j][1]);
            }
            //System.out.println();
            if(t>=low && t<=high)
                dp[s]=true;
        }

        for(int i=1; i<=max; i++){
            if(dp[i]==true){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}



// 10