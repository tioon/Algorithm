package algorithm;

import java.io.*;
import java.util.*;

//백준 1065
public class BeakJoon_13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result=0;

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 유치원생
        int K = Integer.parseInt(s[1]); // 조의 갯수

        String[] a = br.readLine().split(" ");
        int[] array = new int[N];
        for(int i=0; i<N; i ++)
            array[i] = Integer.parseInt(a[i]); // 키 순서대로 입력

        int[] difference = new int[N-1];

        for(int i=0;i<N-1; i++)
            difference[i] = array[i+1] - array[i]; // 유치원생들의 키차이 계산

        Arrays.sort(difference); // 가장 낮은 키차이부터 오름차순 정렬

        // 전체 유치원생 - 조의 갯수  -> 조끼리 나뉘어지는 사잇값 개수
        for(int i=0; i<N-K; i++) // 가장 낮은 키차이 부터 더함,
            result += difference[i];

        bw.write(Integer.toString(result));
        bw.flush();
    }
}