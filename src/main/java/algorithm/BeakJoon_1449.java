package algorithm;

import java.io.*;
import java.util.*;

//백준 1065
public class BeakJoon_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int L = Integer.parseInt(s[1]);
        int[] array = new int[N+1];

        String[] a = br.readLine().split(" ");
        for(int i=1; i<=N; i++)
            array[i] = Integer.parseInt(a[i-1]);

        Arrays.sort(array); // 오름차순으로 배열 정렬

        int end =0; // 테이프 길이가 끝나는 지점
        int tape_count=0; // 테이프 사용 개수
        for(int i=1; i<N+1; i++){
            if(array[i] > end){ // 만약 테이프 끝나는 지점이 현재 배열보다 작다면.
                end = array[i]+L-1; // 테이프 길이 업데이트
                tape_count++; // 테이프 사용 개수 증가
            }
        }

        bw.write(Integer.toString(tape_count));
        bw.flush();

    }
}