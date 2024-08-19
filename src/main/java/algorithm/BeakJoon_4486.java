package algorithm;

import java.io.*;
import java.util.PriorityQueue;

public class BeakJoon_4485 {
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;

        Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }
    static int n;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int round =1;

        while(true){
            n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;

            int[][] array = new int [n][n];
            int[][] minArray = new int[n][n];
            boolean[][] visited = new boolean[n][n];

            result=Integer.MAX_VALUE;

            for(int i=0; i<n; i++){
                String[] s1 = br.readLine().split(" ");

                for(int j=0; j<n; j++){
                    array[i][j] = Integer.parseInt(s1[j]);
                    minArray[i][j] = Integer.MAX_VALUE;
                }
            }

            daikstra(array,minArray,0);

            System.out.println("Problem "+(round++)+": "+minArray[n-1][n-1]);

        }

    }

    public static void daikstra(int[][] array, int[][] minArray, int sum) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(0,0,array[0][0]));
        minArray[0][0] = array[0][0];


        // 이동할 네 가지 방향 (상, 하, 좌, 우)
        int[] xP = {1, -1, 0, 0};
        int[] yP = {0, 0, 1, -1};

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + xP[i];
                int nextY = current.y + yP[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    int nextCost = minArray[current.y][current.x] + array[nextY][nextX];
                    if (nextCost < minArray[nextY][nextX]) {
                        minArray[nextY][nextX] = nextCost;
                        pq.add(new Node(nextX, nextY, nextCost));
                    }
                }
            }
        }
    }
}