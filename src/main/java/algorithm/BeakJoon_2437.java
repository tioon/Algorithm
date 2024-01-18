package algorithm;

import java.io.*;
import java.util.*;

public class BeakJoon_2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int sum=0;

        String[] s= br.readLine().split(" ");
        for(int i=0 ; i<N; i++)
           array[i] = Integer.parseInt(s[i]); // 배열 입력받기

        Arrays.sort(array); // 배열 오름차순 정렬

        for(int i=0; i<N; i++){
            if (array[i] > sum + 1) { // (다음 무게 > 누적합+1)일 시, 해당 수를 만들 수 없게 됨.
                // 측정할 수 없는 양의 정수 무게 중 최솟값 구할 수 있음.
                break;
            }
            sum += array[i]; // sum에 수를 누적하여 더함.
        }

        bw.write(Integer.toString(sum+1)); // 최솟값 출력
        bw.flush();
    }
}

