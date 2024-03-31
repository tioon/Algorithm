package algorithm;

import java.io.*;
import java.util.*;

public class BeakJoon_1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Integer[] crane = new Integer[N];
        for(int i = 0; i < N; i++)
            crane[i] = Integer.parseInt(s[i]);

        int M = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        Integer[] box = new Integer[M];
        for(int i = 0; i < M; i++)
            box[i] = Integer.parseInt(a[i]);

        Arrays.sort(crane, Collections.reverseOrder());
        Arrays.sort(box, Collections.reverseOrder());

        if(crane[0] < box[0]) {
            System.out.println(-1);
            return;
        }

        int[] idx = new int[N]; // 각 크레인이 현재 옮겨야 할 박스의 인덱스
        boolean[] checked = new boolean[M]; // 각 박스가 옮겨졌는지 여부

        int result = 0; // 결과값

        int finished = 0; // 옮겨진 박스 수
        while(finished < M) {
            for(int i = 0; i < N; i++) { // 모든 크레인에 대해
                while(idx[i] < M) { // 옮길 수 있는 박스를 찾을 때까지 반복
                    if(!checked[idx[i]] && crane[i] >= box[idx[i]]) { // 옮길 수 있는 박스를 찾았다면
                        checked[idx[i]] = true; // 박스를 옮겼다고 표시
                        finished++; // 옮겨진 박스 수 증가
                        break;
                    }
                    idx[i]++;
                }
            }
            result++; // 시간 증가
        }

        System.out.println(result);
    }
}
