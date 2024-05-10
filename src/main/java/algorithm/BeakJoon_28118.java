package algorithm;

import java.util.Scanner;

public class BeakJoon_28118 {
    static int n, m, res;
    static int[] c;
    static int[][] g;

    static void dfs(int v){
        c[v] = 1; // 방문 체크
        for(int i=1; i<=n; i++) // 첨붵 끝까지탐색
            if(g[v][i] == 1 && c[i] == 0) // 만약 탐색 안한게 있다면, 재귀 dfs 시작
                dfs(i);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = new int[n+1];
        g = new int[n+1][n+1];

        for(int i=0; i<m; i++){ // 입력
            int u = sc.nextInt();
            int v = sc.nextInt();
            g[u][v] = g[v][u] = 1;
        }

        for(int i=1; i<=n; i++)
            if(c[i] == 0) { // 만약 방문 안했으면 dfs 시작
                dfs(i);
                res++;
            }
        // res는 연결요소의 덩어리 수
        // 즉, 덩어리 수-1 만큼의 비용이 드므로, res-1 출력
        System.out.println(res - 1);
        sc.close();
    }
}