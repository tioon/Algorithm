package algorithm;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BeakJoon_2294 {
    static int n;
    static int k;
    static Set<Integer> coins;
    static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        k = Integer.parseInt(s1[1]);
        coins = new HashSet<>();
        value = new int[k+1];

        // 코인 value 입력
        for(int i=0; i<n; i++)
            coins.add(Integer.parseInt(br.readLine()));

        // 코인값 기반 value 리스트 초기화
        for(int i=1; i<k+1; i++)
            value[i] = Integer.MAX_VALUE;
        for(Integer coin: coins)
            if(coin < k+1) // 동전 값이 리스트보다 큰경우가 제외
                value[coin] = 1;



        // 1번부터 시작
        for(int i=1; i<k+1; i++){
            if(value[i] != Integer.MAX_VALUE){ // MAX_VALUE인 경우 불가능임
                for(Integer coin : coins){ // 현재 + 코인 값 -> 최대치 인지 검증 (이때, 최댓값 초과 확인)
                    if(i+coin<k+1 && value[i+coin] > value[i]+1)
                        value[i+coin] = value[i]+1;
                }
            }
        }


        if(value[k] == Integer.MAX_VALUE) // MAX_VALUE인 경우 불가능한 경우임.
            System.out.println(-1);
        else
            System.out.println(value[k]);
    }
}