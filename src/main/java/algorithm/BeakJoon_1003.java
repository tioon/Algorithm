package algorithm;

import java.io.*;

public class BeakJoon_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] fibonacci0 = new int[41]; // 최댓값 = 40이므로, 41까지만 배열 생성
            int[] fibonacci1 = new int[41];
            fibonacci0[0] = 1; // 초기값은 고정으로 작성
            fibonacci0[1] = 0;
            fibonacci1[0] = 0;
            fibonacci1[1] = 1;
            for(int k = 2; k <= N; k++){ // 피보나치 DP 업데이트
                fibonacci0[k] = fibonacci0[k-1] + fibonacci0[k-2]; //0 배열 업데이트
                fibonacci1[k] = fibonacci1[k-1] + fibonacci1[k-2]; //1 배열 업데이트
            }
            System.out.println(fibonacci0[N] + " " + fibonacci1[N]); // 피보나치 결과 출력
        }
    }
}
