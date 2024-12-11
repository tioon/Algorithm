package algorithm;
import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int m;
    static int[][] array;
    static boolean[][] visited;
    static int[] x_p = {-1,1,0,0};
    static int[] y_p = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);

        array = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String[] s2 = br.readLine().split("");
            for(int j=0; j<s2.length; j++) {
                array[i][j] = Integer.parseInt(s2[j]);
            }
        }

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Integer[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int value = current[2];

            if(y==n-1 && x==m-1){
                System.out.println(value);
                break;
            }

            for(int i=0; i<4; i++){
                int next_y = y+y_p[i];
                int next_x = x+x_p[i];

                if(next_y >=0 && next_y < n && next_x >=0 && next_x < m){
                    if(array[next_y][next_x] == 1 && visited[next_y][next_x] == false){
                        visited[next_y][next_x] = true;
                        queue.add(new Integer[]{next_y, next_x, value+1});
                    }
                }
            }


        }


    }
}
// 40 30 30 20 10