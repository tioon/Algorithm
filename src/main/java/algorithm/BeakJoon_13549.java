package algorithm;

import java.io.*;
import java.util.*;

//백준_13549
public class BeakJoon_13549 {
    static class Node implements Comparable<Node>{ // Node 클래스
        int end;
        int weight;

        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        int getEnd(){
            return this.end;
        }

        int getWeight(){
            return this.weight;
        }

        @Override
        public int compareTo(Node o) { // 우선순위 비교 메서드 (Priority Queue에 필수적으로 필요함)
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] array = new int[100001];

        Arrays.fill(array,Integer.MAX_VALUE);

        Search(array,N,K);

        bw.write(Integer.toString(array[K]));
        bw.flush();


    }

    public static void Search(int[] array, int N,int K){ //탐색 함수
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(N,0)); // 시작점 추가 (우선순위 0)

        while(!queue.isEmpty()){
            Node current = queue.poll(); // Queue에서 하나 추출
            int currentPosition = current.getEnd();
            int currentWeight = current.getWeight();

            array[currentPosition] = currentWeight; // 현재 가중치 업데이트

            if (currentPosition == K)// 도착지일 시 멈춤
                return;


            if (currentPosition*2 <= 100000 && array[currentPosition*2] > currentWeight)  // 우선순위 비교 및 업데이트 (0이 우선순위)
                queue.add(new Node(currentPosition * 2, currentWeight));

            if (currentPosition-1 >= 0 && array[currentPosition-1] > currentWeight+1)  // 우선순위 비교 및 업데이트
                queue.add(new Node(currentPosition - 1, currentWeight + 1));

            if (currentPosition+1 <= 100000 && array[currentPosition+1] > currentWeight+1)  // 우선순위 비교 및 업데이트
                queue.add(new Node(currentPosition + 1, currentWeight + 1));
        }

    }
}