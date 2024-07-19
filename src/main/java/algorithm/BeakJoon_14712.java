package algorithm;

import java.io.*;

public class BeakJoon_14712 {
    static int N;
    static int M;
    static int array[][];
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s1 = br.readLine().split(" ");
        N = Integer.parseInt(s1[0]);
        M = Integer.parseInt(s1[1]);
        array = new int[N][M];

        dfs(0,0);
        System.out.println(count);
    }

    public static void dfs(int x, int y){

        if (y == N) { // 모든 행을 다 탐색했을 때 (종료 조건)
            count++;
            return;
        }


        int nextX; // 다음 x
        int nextY; // 다음 y
        if(x < M-1){  // 가로로 탐색
            nextX=x+1;
            nextY=y;
        }else{ // 가로로 끝까지 도달한 경우 ,다음 열로 이동
            nextX=0;
            nextY=y+1;
        }

        //현재 두지않는 경우
        dfs(nextX, nextY);

        //현재 두는 경우
        // 이전과 비교해서 사각형이 없으면 계속 진행, 없다면 가지치기 (백트래킹)
        if((x==0 || y==0) || (array[y-1][x]==0 || array[y][x-1]==0 || array[y-1][x-1]==0)){
            array[y][x] = 1;
            dfs(nextX, nextY);
            array[y][x] = 0;
        }
    }
}