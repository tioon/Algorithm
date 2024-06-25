package algorithm;

import java.io.*;

public class BeakJoon_14938 {
    static int n; // 지역 개수
    static int m; // 수색 범위
    static int r; // 길의 개수
    static int[] item; // 아이템 값 배열
    static int[][] graph; // 길 배열
    static int result = 0;

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] s1 = br.readLine().split(" ");
    n = Integer.parseInt(s1[0]); // 지역 개수 초기화
    m = Integer.parseInt(s1[1]); // 수색 범위 초기화
    r = Integer.parseInt(s1[2]); // 길의 개수 초기화
    item = new int[n+1];
    graph = new int[n+1][n+1];

    String[] s2 = br.readLine().split(" "); // 아이템 값 배열 초기화
    for(int i=0; i<n; i++){
        item[i+1] = Integer.parseInt(s2[i]);
    }

    for(int i=1; i<n+1; i++){ // 경로 초기값 세팅
        for(int j=1; j<n+1; j++){
            graph[i][j] = Integer.MAX_VALUE;
            if(i == j)
                graph[i][j] = 0;
        }
    }

    for(int i=0; i<r; i++){ // graph 초기화
        String[] s3 = br.readLine().split(" ");
        int a = Integer.parseInt(s3[0]);
        int b = Integer.parseInt(s3[1]);
        int I = Integer.parseInt(s3[2]);
        graph[a][b] = I;
        graph[b][a] = I;
    }


    // 플로이드-와샬 알고리즘
    for(int k=1; k<n+1; k++){
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE &&(graph[i][j] > graph[i][k] + graph[k][j])){
                        graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
    }

    // 모든 시작점 탐방
    for(int i=1; i<n+1; i++){
        int max = 0; // 초기값

        for(int j=1; j<n+1; j++){
            if(graph[i][j] <= m) { // 해당 최단거리가 수색범위 안에 존재할때 최대값 증가
                max += item[j];
            }
        }
        if(result < max)
            result =max;
    }

    System.out.println(result);
    }
}