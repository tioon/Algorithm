package algorithm;

import java.io.IOException;
import java.io.*;
import java.util.*;


//백준_1012
public class BeakJoon_1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 전체 반복 개수

        for(int i=0; i<T ;i++){
            String[] s = br.readLine().split(" ");
            int M = Integer.parseInt(s[0]); // 가로
            int N = Integer.parseInt(s[1]); // 세로
            int K = Integer.parseInt(s[2]); // 배추 개수

            int[][] array = new int[N][M]; // 배추 배열
            int[][] visit = new int[N][M]; // 방문 배열
            int earthworm = 0; // 필요한 지렁이 개수

            for(int j=0; j<K; j++){ // 배추 위치 입력
                String[] a = br.readLine().split(" ");
                array[Integer.parseInt(a[1])][Integer.parseInt(a[0])] = 1;
            }

            for(int x=0; x<M; x++){ // dfs 시작 (새로운 부분 탐색)
                for(int y=0; y<N; y++){
                    if(array[y][x]==1 && visit[y][x]==0) {
                        dfs(x, y, array, visit);
                        earthworm++; // 지렁이 증가
                    }
                }
            }

            bw.write(earthworm+"\n");
            bw.flush();
        }

    }

    public static void dfs(int x, int y, int[][] array, int[][] visit){ //dfs 함수 (배추 무리 탐색)
        int[] x_p = {-1,1,0,0};
        int[] y_p = {0,0,-1,1};

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visit[y][x]=1;

        while(!stack.isEmpty()){ // 스택이 비어있을때 까지 반복
            int[] item = stack.pop();

            for(int i=0;i<4;i++){ // 현재 배추에서 상하좌우로 이동
                int next_x = item[0]+x_p[i];
                int next_y = item[1]+y_p[i];


                if(next_x>=0 && next_x<array[0].length && next_y>=0 && next_y<array.length) { // 알맞은 배열범위인지 탐색
                    if (array[next_y][next_x] == 1 && visit[next_y][next_x] == 0) { // 아직 탐색안한 배추면 stack에 저장
                        stack.push(new int[]{next_x, next_y});
                        visit[next_y][next_x] = 1; //방문 표시
                    }
                }
            }
        }

    }
}
