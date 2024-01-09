package algorithm;

import java.io.*;


public class BeakJoon_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int S = Integer.parseInt(br.readLine());
        int[] stair = new int[S]; // 계단 배열
        int[] DP = new int[S]; // DP 저장 배열

        for(int i=0 ; i<S; i++){
            stair[i] = Integer.parseInt(br.readLine()); // 계단 배열 입력
        }

        for(int i=0; i<S; i++){
            if(i==0) // DP 0
                DP[i] = stair[0];
            else if(i==1) // DP 1
                DP[i] = stair[0] + stair[1];
            else if(i==2) // DP 2
                DP[i] = Math.max(stair[0]+stair[2],stair[1]+stair[2]);
            else{ // DP 3 이후 (최대값 선택)
                  // 1. -2 까지의 최댓값 + 현재 계단
                  // 2. -3 까지의 최댓값 + 전 계단 + 현재 계단
                DP[i] = Math.max(DP[i-2] + stair[i],DP[i-3] + stair[i-1] + stair[i]);
            }
        }

        bw.write(Integer.toString(DP[S-1]));
        bw.flush();

    }
}
