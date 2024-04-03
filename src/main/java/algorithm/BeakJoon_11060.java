package algorithm;

import java.io.*;

public class BeakJoon_11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] min = new int[N];

        String[] s= br.readLine().split(" ");
        for(int i=0; i<N; i++)
            array[i] = Integer.parseInt(s[i]);

        for(int i=1; i<N; i++)
            min[i] = Integer.MAX_VALUE; // 맨 처음 위치 빼고, 최댓값 설정

        for(int i=0; i<N; i++){ // 첨부터 끝까지 반복
            if(min[i] == Integer.MAX_VALUE) // 점프할 수 없는 곳은 패스 (최댓값이라면, 이전에 도착하지 못해서 업데이특 안된 것)
                continue;
            for(int j=1; j<array[i]+1; j++){ // 해당 위치에서 점프할 수 있는 곳 업데이트
                if(i+j < N){
                    if(min[i+j] > min[i]+1)
                        min[i+j] = min[i] + 1; // (이전 최소값 vs 현재 최소값) 비교 후, 업데이트
                }
            }
        }

        if(min[N-1] == Integer.MAX_VALUE ) // 만약 마지막 위치가 최대값을 가지고 있다면, 방문하지 못한것.
            System.out.println(-1); // 실패 출력
        else
            System.out.println(min[N-1]); // 마지막 위치의 최솟값 출력 -> 오른쪽 끝 칸으로 갈 수 있는 최단방법


    }
}