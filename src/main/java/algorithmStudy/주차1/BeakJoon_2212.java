package algorithmStudy.주차1;

import java.io.*;
import java.util.*;

// 센서 (1주차 3번문제)
public class BeakJoon_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensor = new int[N];

        String[] s1 = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            sensor[i] = Integer.parseInt(s1[i]);
        }

        // 센서 오름차순 정렬 -> 센서 위치 파악
        Arrays.sort(sensor);

        // 센서간의 거리 차이 계산
        Integer[] diff = new Integer[N-1];
        for(int i=0; i<N-1; i++){
            diff[i] = sensor[i+1] - sensor[i];
        }

        // 센서간의 거리 오름차순 정렬
        Arrays.sort(diff);


        // 센서간의 거리가 제일 작은거 부터 선택
        // (센서개수 - 집중국개수) -> 집중국 사이의 거리 최소값 구함
        int sum = 0;
        for(int i=0; i<N-K; i++){
            sum += diff[i];
        }

        System.out.println(sum);
    }
}

//1 3 6 7 9
// 2 3 1 2