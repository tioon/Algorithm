package algorithmStudy.주차1;

import java.util.*;

class Programmers_2{
    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        // costs 거리순 오름차순 정렬
        Arrays.sort(costs, (o1,o2) -> o1[2] - o2[2]);

        // 거리가 가장 짧은것부터 순차적 탐색
        for(int i=0; i<costs.length; i++){
            int start = costs[i][0];
            int end = costs[i][1];
            int value = costs[i][2];

            // 만약 둘이 이어진 섬이 아니라면
            if(find(start) != find(end)){
                union(start,end); // 섬 연결
                answer+=value; // 비용 증가
            }
        }

        System.out.println(answer);
        return answer;
    }

    // (유니온-파인드)
    public int find(int index){
        // 자기자신이 부모라면 반환
        if(parent[index] == index){
            return index;
        }
        // 아니라면, 부모를 다시 탐색
        return find(parent[index]);
    }
    public void union(int start, int end){
        int rootStart = find(start);
        int rootEnd = find(end);

        // 서로 부모가 다르다면
        if(rootStart != rootEnd) {
            parent[rootEnd] = rootStart; // 부모 연결
        }
    }
}