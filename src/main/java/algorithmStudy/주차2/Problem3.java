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

        for(int i=0; i<n; i++){
            String[] s1 = br.readLine().split("");
            for(int j=0; j<n; j++){
                boom[i][j] = s1[j].charAt(0);
            }
        }

        for(int i=0; i<n; i++){
            String[] s2 = br.readLine().split("");
            for(int j=0; j<n; j++){
                visit[i][j] = s2[j].charAt(0);
            }
        }

        boolean isBoomClicked = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visit[i][j] == 'x'){
                    result[i][j] = (char)(check(i,j)+'0');
                    if (boom[i][j] == '*') {
                        isBoomClicked = true; // 지뢰 클릭 여부 체크
                    }
                }
                else{
                    result[i][j] = '.';
                }
            }
        }

        // 지뢰 클릭 시 모든 지뢰 표시
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

        for(int i=-1; i<2; i++){
            for(int j=-1; j<2; j++){
                int nextX = x+j;
                int nextY = y+i;

                if(nextX>=0 && nextX<n && nextY>=0 && nextY<n){
                    if(boom[nextY][nextX] == '*')
                        count++;
                }
            }
        }

        return count;
    }
}
