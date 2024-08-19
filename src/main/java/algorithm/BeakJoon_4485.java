package algorithm;

import java.io.*;
import java.util.Arrays;

public class BeakJoon_4485 {
    static int n;
    static Node[] list;
    static class Node implements Comparable<Node>{
        int location;
        int color;

        Node(int location, int color){
            this.location = location;
            this.color = color;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(location, o.location);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new Node[n];

        for(int i=0; i<n; i++){
            String[] s1 = br.readLine().split(" ");
            list[i] = new Node(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]));
        }

        Arrays.sort(list);

        int result=0;
        for(int i=0; i<n; i++){
            int length = searchNode(i);
            result+=length;
        }

        System.out.println(result);

    }

    public static int searchNode(int location) {
        Node current = list[location];
        int frontDistance = Integer.MAX_VALUE;
        int backDistance = Integer.MAX_VALUE;

        // 앞쪽 탐색
        for (int i = location + 1; i < n; i++) {
            if (list[i].color == current.color) {
                frontDistance = Math.abs(current.location - list[i].location);
                break;
            }
        }

        // 뒤쪽 탐색
        for (int i = location - 1; i >= 0; i--) {
            if (list[i].color == current.color) {
                backDistance = Math.abs(current.location - list[i].location);
                break;
            }
        }

        // 더 작은 거리를 반환
        return Math.min(frontDistance, backDistance);
    }

}
