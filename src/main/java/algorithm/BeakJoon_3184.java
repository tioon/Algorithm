package algorithm;

import java.io.*;

public class BeakJoon_3184 {
    static int r;
    static int c;
    static char[][] array;
    static boolean[][] visited;
    static int sheep;
    static int wolf;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        r = Integer.parseInt(s1[0]);
        c = Integer.parseInt(s1[1]);

        array = new char[r][c];
        visited = new boolean[r][c];
        for(int i=0; i<r ;i++){
            String[] s2 = br.readLine().split("");
            for(int j=0; j<c; j++){
                array[i][j] =s2[j].charAt(0);
            }
        }

        int resultSheep=0;
        int resultWolf=0;
        for(int i=0; i<r ;i++){
            for(int j=0; j<c; j++){
                if(array[i][j]!='#' && visited[i][j]==false) {
                    sheep=0;
                    wolf=0;

                    dfs(i,j);

                    if(sheep > wolf)
                        resultSheep+=sheep;
                    else
                        resultWolf+=wolf;
                }
            }
        }

        System.out.println(resultSheep+" "+resultWolf);
    }

    public static void dfs(int y, int x){
        int[] x_p = {-1,0,0,1};
        int[] y_p = {0,-1,1,0};

        visited[y][x] = true;
        char value = array[y][x];

        switch(value){
            case 'o':
                sheep++;
                break;
            case 'v':
                wolf++;
                break;
            default :
                break;
        }

        for(int i=0; i<4; i++){
            int currentX = x+x_p[i];
            int currentY = y+y_p[i];

            if(currentX>=0 && currentX<c && currentY>=0 && currentY<r){
                if(array[currentY][currentX]!='#' && visited[currentY][currentX]==false){
                    dfs(currentY, currentX);
                }
            }
        }
    }
}