package algorithm;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int v, e;
    static int[][] dist;
    static final int INF = 1000000000; // 충분히 큰 값 (무한대를 표현)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s1 = br.readLine().split(" ");
        v = Integer.parseInt(s1[0]);
        e = Integer.parseInt(s1[1]);
        dist = new int[v + 1][v + 1];

        // 거리 배열 초기화
        for (int i = 1; i <= v; i++) {
            Arrays.fill(dist[i], INF);
        }

        // 간선 정보 입력
        for (int i = 0; i < e; i++) {
            String[] s2 = br.readLine().split(" ");
            int start = Integer.parseInt(s2[0]);
            int end = Integer.parseInt(s2[1]);
            int value = Integer.parseInt(s2[2]);
            dist[start][end] = value;
        }

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 최소 사이클 찾기
        int minCycle = INF;
        for (int i = 1; i <= v; i++) {
            if (dist[i][i] < minCycle) {
                minCycle = dist[i][i];
            }
        }

        // 결과 출력
        if (minCycle == INF) {
            System.out.println(-1);
        } else {
            System.out.println(minCycle);
        }
    }
}
