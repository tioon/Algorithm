package algorithm;

import java.io.*;
import java.util.*;

public class BeakJoon_2961 {
    static class Cook{
        int sour; // 신맛
        int bitter; // 쓴맛

        Cook(int sour,int bitter){
            this.sour = sour;
            this.bitter = bitter;
        }
    }

    static int N; // 재료의 개수
    static List<Cook> cooks; // 요리 리스트
    static int max = Integer.MAX_VALUE; // 최댓값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());
        cooks = new ArrayList<Cook>();
        for(int i=0; i<N; i++){ // 요리 정보 초기화
            String[] s1 = br.readLine().split(" ");
            int sour = Integer.parseInt(s1[0]);
            int bitter = Integer.parseInt(s1[1]);
            cooks.add(new Cook(sour,bitter));
        }

        dfs(0,1,0); // dfs 시작

        System.out.println(max);
    }
    public static void dfs(int index, int sour, int bitter){
        if(index == N){ // 만약 모든 요리를 다돌았을 시 dfs 종료
            if(max > Math.abs(sour - bitter) && bitter != 0) // 최댓값 > 맛차이 일 경우 + 하나이상 요리선택한 경우 (쓴 맛은 무조건 값이 변함)
                max = Math.abs(sour - bitter);
            return;
        }

        Cook cook = cooks.get(index);
        dfs(index+1, sour*cook.sour, bitter+cook.bitter); // 현재 요리 선택
        dfs(index+1, sour, bitter); // 현재 요리 선택 x
    }
}