package algorithmStudy.주차2;

import java.io.*;

//백준 1212
public class Problem3 {
    static char[][] boom ;
    static char[][] visit ;
    static char[][] result;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        boom = new char[n][n];
        visit = new char[n][n];
        result = new char[n][n];

        // 폭탄위치 입력
        for(int i=0; i<n; i++){
            String[] s1 = br.readLine().split("");
            for(int j=0; j<n; j++){
                boom[i][j] = s1[j].charAt(0);
            }
        }

        // 방문상황 입력
        for(int i=0; i<n; i++){
            String[] s2 = br.readLine().split("");
            for(int j=0; j<n; j++){
                visit[i][j] = s2[j].charAt(0);
            }
        }

        boolean isBoomClicked = false;
        // 완전 탐색
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // 만약 방문한 곳이라면 check함수 호출 값 업데이트
                if(visit[i][j] == 'x'){
                    result[i][j] = (char)(check(i,j)+'0');
                    if (boom[i][j] == '*') {
                        isBoomClicked = true; // 만약 폭탄 있을 시, 지뢰 클릭 여부 체크
                    }
                }
                // 만약 방문하지 않은 곳이라면 .으로 업데이트
                else{
                    result[i][j] = '.';
                }
            }
        }

        // 만약 이미 지뢰를 밟았다면, 모든 지뢰 표시
        if (isBoomClicked) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (boom[i][j] == '*') {
                        result[i][j] = '*';
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(result[i]);
            bw.write('\n');
        }
        bw.flush();


    }

    public static int check(int y,int x){
        int count =0;

        // 상하좌우 및 대각선에 폭탄이 몇개 존재하는지 체크
        for(int i=-1; i<2; i++){
            for(int j=-1; j<2; j++){
                int nextX = x+j;
                int nextY = y+i;

                if(nextX>=0 && nextX<n && nextY>=0 && nextY<n){
                    if(boom[nextY][nextX] == '*')
                        count++; // 폭탄 존재시 count++;
                }
            }
        }

        return count;
    }
}
