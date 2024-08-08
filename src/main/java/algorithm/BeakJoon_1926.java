package algorithm;

import java.io.*;

public class BeakJoon_1926 {
    static int n; // 세로
    static int m; // 가로
    static int[][] array;
    static boolean[][] visited;
    static int count;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);

        array = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String[] s2 = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                array[i][j] = Integer.parseInt(s2[j]);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(array[i][j]==1 && visited[i][j]==false) {
                    result = Math.max(dfs(i, j, 1), result);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(result);
    }

    public static int dfs(int q, int w, int depth){
        int[] x = {-1,0,0,1};
        int[] y = {0,-1,1,0};

        visited[q][w] = true;
        int size = 1; // 현재 위치 포함

        for(int i=0; i<4; i++){
            int nextX = w + x[i];
            int nextY = q + y[i];

            if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                if (array[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    size += dfs(nextY, nextX, depth + 1); // 재귀적으로 크기를 더해 나감
                }
            }
        }
        return size;
    }
}