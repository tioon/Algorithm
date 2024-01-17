package algorithm;

import java.io.*;

public class BeakJoon_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] array = new int[2][n];
            int[][] DP = new int[2][n]; // DP 배열

            for(int j=0; j<2; j++){
                String[] a = br.readLine().split(" ");
                for(int k=0; k<n; k++)
                    array[j][k] = Integer.parseInt(a[k]); // 스티커의 가격 입력
            }

            for(int j=0; j<n; j++){
                if(j==0){ // 첫번째 줄 DP
                    DP[0][j] = array[0][j];
                    DP[1][j] = array[1][j];
                }
                else if(j==1){ // 두번째 줄 DP
                    DP[0][j] = DP[1][j-1] + array[0][j];
                    DP[1][j] = DP[0][j-1] + array[1][j];
                }
                else{// 세번쨰 이상 줄 DP
                    DP[0][j] = Math.max(DP[1][j-1] + array[0][j], Math.max(DP[0][j-2],DP[1][j-2]) + array[0][j]);
                    DP[1][j] = Math.max(DP[0][j-1] + array[1][j], Math.max(DP[0][j-2],DP[1][j-2]) + array[1][j]);
                    // 1줄 전 DP+현재 줄(1개) OR 2줄 전 DP+현재 줄(2개)  최댓값 업데이트
                }
            }

            bw.write(Integer.toString(Math.max(DP[0][n-1],DP[1][n-1]))+'\n'); // 2개중에 최댓 값 선택
        }

        bw.flush();

    }
}

