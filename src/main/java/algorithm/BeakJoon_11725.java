package algorithm;

import java.io.*;
import java.util.*;

//백준 1065
public class BeakJoon_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[N+1]; // 노드 연결리스트
        boolean[] visited = new boolean[N+1]; // 방문한 노드 리스트
        int[] parent = new int[N+1]; // 노드의 부모 리스트

        for(int i=1; i<N+1; i++)
            list[i] = new ArrayList<>(); // 연결리스트

        for(int i=1; i<N; i++){
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]); // 시작 노드
            int end = Integer.parseInt(s[1]); // 끝 노드

            list[start].add(end);
            list[end].add(start);
        }

        bfs(list, visited, parent, N);

        for(int i=2; i<N+1; i++){
            bw.write(Integer.toString(parent[i])+'\n');
        }

        bw.flush();
    }

    static void bfs(ArrayList<Integer>[] list, boolean[] visited, int[] parent, int N){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1); // 1이 부모 -> 처음에 넣음

        while(!queue.isEmpty()){
            int current = queue.poll();
            visited[current] = true; // 방문처리
            int size = list[current].size();

            for(int i=0; i<size; i++){ // current 노드와 연결된 노드들을 탐색
                int linkedNode = list[current].get(i);

                if(visited[linkedNode] == true){ // 이미 방문한 노드 -> current의 부모노드임
                    parent[current] = linkedNode;
                }
                else{ // 방문하지 않은 노드 -> current의 자식노드임 -> queue에 넣음
                    queue.add(linkedNode);
                }
            }
        }
    }
}