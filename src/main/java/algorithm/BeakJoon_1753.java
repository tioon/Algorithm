package algorithm;

import java.io.*;
import java.util.*;

//백준_1753
public class BeakJoon_1753 {
    static class Node implements Comparable<Node> { // 노드 클래스
        int end; // 도착지
        int weight; // 가중치

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        int getEnd() {
            return this.end;
        }

        int getWeight() {
            return this.weight;
        }

        @Override
        public int compareTo(Node other) { // 우선순위 큐에서 우선순위 비교하기 위한 메서드
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        int start = Integer.parseInt(br.readLine());

        List<Node>[] graph = new ArrayList[V + 1]; //전체 경로 리스트 (Node)
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] distances = new int[V + 1]; // 최저 경로 배열
        boolean[] visited = new boolean[V + 1]; // 방문 유무 배열
        Arrays.fill(distances, Integer.MAX_VALUE); // 최저 경로 배열 최대값으로 초기화

        for (int i = 0; i < E; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int u = Integer.parseInt(edgeInfo[0]); // 시작점
            int v = Integer.parseInt(edgeInfo[1]); // 도착적
            int w = Integer.parseInt(edgeInfo[2]); // 가중치
            graph[u].add(new Node(v, w));
        }

        dijkstra(graph, distances, visited, start);

        for (int i = 1; i <= V; i++) {
            if (i == start) {
                bw.write("0\n");
            } else if (distances[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(distances[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(List<Node>[] graph, int[] distances, boolean[] visited, int start) { // 다익스트라 알고리즘 함수
        PriorityQueue<Node> queue = new PriorityQueue<>();
        distances[start] = 0;
        queue.add(new Node(start, distances[start])); //시작점 node 삽입 (가중치 0)

        while (!queue.isEmpty()) { // Queue가 빌때까지 반복
            Node current = queue.poll(); // Queue에서 현재 노드 꺼냄.
            int currentNode = current.getEnd();

            if (visited[currentNode]) continue; // 이미 방문한 노드는 스킵함.
            visited[currentNode] = true; // 해당 노드 방문 처리

            for (Node neighbor : graph[currentNode]) { // 현재 노드의 연결된 이웃노드들 탐색 및 연결
                if (distances[neighbor.getEnd()] > distances[currentNode] + neighbor.getWeight()) { // 현재 최저 경로보다 짧으면 업데이트 후 Queue 삽입.
                    distances[neighbor.getEnd()] = distances[currentNode] + neighbor.getWeight();
                    queue.add(new Node(neighbor.getEnd(), distances[neighbor.getEnd()])); //
                }
            }
        }
    }
}

