package algorithm;

import java.io.*;
import java.util.Arrays;

public class BaekJoon_14284 {
    static int n;
    static int m;
    static int s;
    static int t;
    static int[][] array;
    static boolean[] visited;
    static int[] min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        array = new int[n+1][n+1];
        min = new int[n+1];
        visited = new boolean[n+1];

        // 인접 행렬 초기화
        for (int i = 0; i <= n; i++) {
            Arrays.fill(array[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<m; i++){
            String[] s2 = br.readLine().split(" ");
            int start = Integer.parseInt(s2[0]);
            int end = Integer.parseInt(s2[1]);
            int value = Integer.parseInt(s2[2]);
            array[start][end] = value;
            array[end][start] = value;
        }

        String[] s3 = br.readLine().split(" ");
        s = Integer.parseInt(s3[0]);
        t = Integer.parseInt(s3[1]);

        Arrays.fill(min,Integer.MAX_VALUE);
        min[s] = 0;


        //시작점 초기화
        for (int i = 1; i <= n; i++) {
            if (array[s][i] != Integer.MAX_VALUE) {
                min[i] = array[s][i];
            }
        }

        daikstra(s);

        System.out.println(min[t]);
    }

    public static void daikstra(int start){
        // 방문처리
        visited[start] = true;



        for(int i=1; i<n; i++) {
            int minValue = Integer.MAX_VALUE;
            int location=0;

            //가장 최소인 지점 찾기
            for (int j = 1; j < n + 1; j++) {
                if (!visited[j] && j != start && minValue > min[j]) {
                    minValue = min[j];
                    location = j;
                }
            }

            if (location == 0) break; // 더 이상 방문할 노드가 없으면 종료

            visited[location] = true; // 최소 지점을 방문 처리

            //값 업데이트
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && array[location][j] != Integer.MAX_VALUE && min[location] != Integer.MAX_VALUE &&
                        min[j] > min[location] + array[location][j]) {
                    min[j] = min[location] + array[location][j];
                }
            }
        }
    }


}