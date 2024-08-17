package algorithm;

import java.io.*;

public class BeakJoon_14594 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];

        for(int i=1; i<n+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            String[] s1 = br.readLine().split(" ");
            int start = Integer.parseInt(s1[0]);
            int end = Integer.parseInt(s1[1]);

            union(start,end);
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (find(i) == i) {
                result++;
            }
        }

        System.out.println(result);


    }
    static int find(int x){
        if(parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }
    static void union(int start, int end){
        int rootFirst = find(start);
        for(int i=start+1; i<=end; i++){
            int rootI = find(i);
            if(rootI != rootFirst){
                parent[rootI] = rootFirst;
            }
        }
    }
}