package algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BeakJoon_18352 {
    static int[] result;
    static boolean[] visited;

    static class Node implements Comparable<Node>{
        int vertex; // 방문 유무 배열
        int distance; // 거리 배열

        Node(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.distance, other.distance);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s1 = br.readLine().split(" ");
        int N = Integer.parseInt(s1[0]); // 도시의 개수
        int M = Integer.parseInt(s1[1]); // 도로의 개수
        int K = Integer.parseInt(s1[2]); // 거리 정보
        int X = Integer.parseInt(s1[3]); // 출발 도시의 번호
        List<Integer>[] graph = new List[N+1];
        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        result = new int[N+1];

        for(int i=1; i<N+1; i++){
            result[i] = Integer.MAX_VALUE; // 최단 거리 배열 MAX 값으로 초기화
        }
        result[X] = 0;

        for(int i=0; i<M; i++){ // 노드 연결리스트 초기화
            String[] s2 = br.readLine().split(" ");
            graph[Integer.parseInt(s2[0])].add(Integer.parseInt(s2[1]));
        }

        dijkstra(graph, N, X); // 다익스트라 실행

        for(int i=1; i<N+1; i++) { // 조건에 일치하는 최단거리 값 추출
            if (result[i] == K) {
                sb.append(i).append('\n');
            }
        }

        if(sb.length()==0)
            System.out.println(-1);
        else
            System.out.println(sb.toString());
    }

    public static void dijkstra(List<Integer>[] graph, int N, int X){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X,0)); // 시작점 삽입

        while(!pq.isEmpty()){
            Node current = pq.poll(); // 현재 노드 출력
            int vertex = current.vertex;

            if(visited[vertex] == true) continue; // 만약 방문했던 노드일 시 무시
            visited[vertex] = true; // 방문 처리

            for(int neighbor : graph[vertex]){ // 현재 노드와 연결된 이웃 노드들을 탐색 (방문 안된 것만)
                if(visited[neighbor] == false){
                    if(result[neighbor] > result[vertex] + 1) { // 기존 이웃 노드의 최단 거리 > 현재 노드 거친 거리
                        result[neighbor] = result[vertex] + 1;
                        pq.add(new Node(neighbor, result[vertex]+1)); // 최단 거리 업데이트 후 pq 업데이트
                    }
                }
            }
        }
    }
}