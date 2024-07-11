package algorithm;

import java.util.*;
import java.io.*;

public class Alice_03 {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] canWin;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        canWin = new boolean[N+1];

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++){
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);

            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(1,-1); // 루트 노드부터 시작

        for (int i = 1; i <= N; i++) {
            System.out.println(canWin[i] ? 1 : 0);
        }
    }

    private static int dfs(int node, int parent) {
        int max = Integer.MIN_VALUE; // 최대값으로

        if(list.get(node).size() == 1 && list.get(node).get(0) == parent){ // 리프 노드일 땐 자기자신 반환
            max = node;
            canWin[node] = true; // 무조건 선공이 이김
            return node;
        }



        // 자식노드 방문
        for(int i=0; i<list.get(node).size(); i++){
            int child = list.get(node).get(i);

            // 부모는 제외 -> 자식만 탐방
            if(child != parent){
                int result = node - dfs(child,node); // 현재 노드값 - 다음 노드값.
                if(max < result) // 최대값 저장
                    max = result;
            }
        }


        if(max >= 0) // 양수일 경우, 선공이 이김
            canWin[node] = true;

        return max;

    }

}
