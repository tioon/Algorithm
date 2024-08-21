package algorithm;

import java.io.*;

public class BeakJoon_2644 {
    static int n;
    static int m;
    static int start;
    static int end;

    static int[][] array;
    static boolean[] visit;
    static int result ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String[] s1 =br.readLine().split(" ");
        start = Integer.parseInt(s1[0]);
        end = Integer.parseInt(s1[1]);
        array = new int[n+1][n+1];
        visit = new boolean[n+1];

        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);

            array[a][b] = 1;
            array[b][a] = 1;
        }

        dfs(start,0);

        if(result==0)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    public static void dfs(int current, int index){
        if(current == end){
            result = index;
        }

        visit[current] = true;

        for(int i=1; i<=n; i++){
            if(array[current][i]==1 && visit[i]==false){
                dfs(i,index+1);
            }
        }
    }
}