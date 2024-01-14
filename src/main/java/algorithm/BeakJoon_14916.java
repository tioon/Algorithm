package algorithm;

import java.io.*;

//백준 1065
public class BeakJoon_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] DP = new int [1000001];

        DP[1]=0;
        DP[2]=1;
        DP[3]=0;
        DP[4]=2;
        DP[5]=1;

        for(int i=6; i<=N; i++){
            if(DP[i-2]!=0 && DP[i-5]!=0)
                DP[i] = Math.min(DP[i-2],DP[i-5])+1; // 이전 거스름돈 중에서  2 OR 5 최솟값 정함

            else if(DP[i-2]==0 && DP[i-5]==0)
                DP[i] =0; // 이전 거스름돈이 둘다 0일경우 0으로 저장

            else
                DP[i] = Math.max(DP[i-2],DP[i-5])+1; // 이전 거스름돈 중에서 한 값만 존재할경우 해당 값만 저장
        }

        if(DP[N]== 0)
            bw.write(Integer.toString(-1));
        else
            bw.write(Integer.toString(DP[N]));

        bw.flush();

    }
}