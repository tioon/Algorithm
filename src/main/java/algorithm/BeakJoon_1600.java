package algorithm;

import java.io.*;
import java.util.PriorityQueue;

public class BeakJoon_1600 {
    static class Node implements Comparable<Node> {
        int x, y, count, limit;

        Node(int x, int y, int count, int limit) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.limit = limit;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.count, o.count);
        }
    }

    static int k, w, h;
    static int[][] array;
    static boolean[][][] visited; // 말 이동 횟수에 따른 방문 여부를 저장
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        w = Integer.parseInt(s1[0]);
        h = Integer.parseInt(s1[1]);

        array = new int[h][w];
        visited = new boolean[h][w][k + 1];

        for (int i = 0; i < h; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                array[i][j] = Integer.parseInt(s2[j]);
            }
        }

        move();
        if (result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    public static void move() {
        int[] oneX = {-1, 1, 0, 0};
        int[] oneY = {0, 0, -1, 1};
        int[] twoX = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] twoY = {-1, 1, -2, 2, -2, 2, -1, 1};

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0, k));
        visited[0][0][k] = true;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.x == w - 1 && current.y == h - 1) {
                result = current.count;
                return;
            }

            // 기본 이동
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + oneX[i];
                int nextY = current.y + oneY[i];

                if (nextX >= 0 && nextX < w && nextY >= 0 && nextY < h && array[nextY][nextX] == 0 && !visited[nextY][nextX][current.limit]) {
                    visited[nextY][nextX][current.limit] = true;
                    pq.add(new Node(nextX, nextY, current.count + 1, current.limit));
                }
            }

            // 말 이동
            if (current.limit > 0) {
                for (int i = 0; i < 8; i++) {
                    int nextX = current.x + twoX[i];
                    int nextY = current.y + twoY[i];

                    if (nextX >= 0 && nextX < w && nextY >= 0 && nextY < h && array[nextY][nextX] == 0 && !visited[nextY][nextX][current.limit - 1]) {
                        visited[nextY][nextX][current.limit - 1] = true;
                        pq.add(new Node(nextX, nextY, current.count + 1, current.limit - 1));
                    }
                }
            }
        }
    }
}
