package algorithm;

import java.io.*;


public class BeakJoon_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        long[] DP = new long[n];

        for(int i=0; i<n; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<n; i++){
            if(i==0) // DP의 처음에는 와인의 첫번째 값을 넣음
                DP[i] = wine[0];
            else if(i==1) // DP의 두번째에는 와인1 + 와인2의 값을 넣음
                DP[i] = wine[1]+wine[0];
            else if(i==2) // 3가지의 경우중 가장 큰 값 선택
                DP[i] = Math.max(Math.max(wine[0]+wine[1] , wine[0]+wine[2]) , wine[1]+wine[2]);
            else{ // OOX, OXO, XOO 3가지의 경우중에서 가장 큰값을 저장함.
                // '마지막 숫자를 꼭 거쳐야함'이라는 조건이 없으므로, 계단 오르기 문제와 다르게 'OOX'의 경우와 추가됨.
                // 'OOX'의 경우엔, 현재 wine을 선택하지않고 그 전의 최댓값을 선택함.
                DP[i] = Math.max(Math.max(DP[i-1] , DP[i-2]+wine[i]) , DP[i-3]+wine[i-1]+wine[i]);
            }
        }

        bw.write(Long.toString(DP[n-1]));
        bw.flush();
    }
}