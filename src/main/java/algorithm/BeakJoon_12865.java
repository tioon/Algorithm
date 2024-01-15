package algorithm;

import java.io.*;
public class BeakJoon_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 물품의 개수
        int M = Integer.parseInt(s[1]); // 배낭의 최대 무게
        int[] weights = new int[N]; // 물품 무게 배열
        int[] values = new int[N]; // 물품 가치 배열
        int[][] dp = new int[N + 1][M + 1]; // DP 배열

        // 각 물품의 무게와 가치를 입력받음
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            weights[i] = Integer.parseInt(input[0]);
            values[i] = Integer.parseInt(input[1]);
        }

        // DP를 이용하여 최대 가치 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int weight = weights[i-1]; // 현재 물품 무게
                int value = values[i-1]; // 현재 물품 가치

                dp[i][j] = dp[i - 1][j]; // 현재 물품을 선택하지 않음 -> 그전 DP에서 그대로 가지고 옴.

                if (j >= weights[i - 1]) { // 현재 물품을 선택함 -> 이전 DP값 | 현재 물품 + 이전 DP에서 물품무게 뺀 DP값
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weight]+value);
                }
            }
        }

        // 최대 가치 출력
        bw.write(Integer.toString(dp[N][M]));
        bw.flush();
    }
}
