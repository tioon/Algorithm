package algorithmStudy.주차1;

import java.io.*;
import java.util.Arrays;

// 빵집 (1주차 1번문제)
public class BeakJoon_3109 {
    static int r;
    static int c;
    static boolean[][] check;
    static char[][] array;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        r = Integer.parseInt(s1[0]);
        c = Integer.parseInt(s1[1]);

        array = new char[r][c];
        check = new boolean[r][c];

        for(int i=0; i<r; i++){
            String[] s2 = br.readLine().split("");
            for(int j=0; j<c; j++) {
                array[i][j] = s2[j].charAt(0);
            }
        }

        // 빵집 가스관 시작
        for(int i=0; i<r; i++){
            if(dfs(i,0)){ // true면 도착점까지 도착했으므로 카운트 증가
                answer++;
            }

        }



        System.out.println(answer);
    }

    public static boolean dfs(int y, int x){
        int[] next = {-1,0,1};

        check[y][x] = true; // 도착 표시

        // 원웅이 빵집 도착 시, true
        if(x == c-1){
            return true;
        }

        for(int i=0; i<3; i++){
            int nextY = y+next[i];
            int nextX = x+1;

            if(nextY>=0 && nextY<r){
                // 건물이 없고, 아직 방문하지 않은 곳이라면 방문
                if(array[nextY][nextX] != 'x' && check[nextY][nextX] == false){
                    if(dfs(nextY, nextX)){
                        return true;
                    }
                }
            }
        }
        return false; // 방문 못했을 경우 false
    }
}