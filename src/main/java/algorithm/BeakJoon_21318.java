package algorithm;

import java.io.*;

public class BeakJoon_21318 {
    static int N;
    static int[] sheetMusic;
    static int Q;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 악보 및 질문 입력
        N = Integer.parseInt(br.readLine());
        sheetMusic = new int[N+1];
        prefixSum = new int[N+1];
        String[] s1 = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            sheetMusic[i] = Integer.parseInt(s1[i-1]);
        }
        Q = Integer.parseInt(br.readLine());

        // 누적합 초기화
        int sum=0;
        for(int i=2; i<=N; i++){ // 이전 악보 > 지금 악보 일 경우 -> 이전 악보에서 실수하므로 sum 증가
            if(sheetMusic[i-1] > sheetMusic[i]) {
                sum++;
            }
            prefixSum[i] = sum; // 현재 sum 값 기준으로 누적합 배열 초기화
        }
        prefixSum[N] = sum; // 맨 마지막 악보는 실수하지 않으므로, 그냥 최종 sum값 그대로 넣음


        // 질문 기반 누적합 계산 후 출력
        for(int i=0; i<Q; i++){
            String[] s2 = br.readLine().split(" ");
            int x = Integer.parseInt(s2[0]);
            int y = Integer.parseInt(s2[1]);

            System.out.println(prefixSum[y] - prefixSum[x]);
        }

    }
}