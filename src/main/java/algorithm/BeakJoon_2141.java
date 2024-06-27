package algorithm;

import java.io.*;
import java.util.PriorityQueue;


public class BeakJoon_2141 {

    static class Node implements Comparable<Node> {
        int x; // 위치
        int y; // 인원 수
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override // 현재 마을의 위치를 기반으로 우선순위 큐 정렬하기 위해 사용
        public int compareTo(Node o) {
            return this.x - o.x;
        }



    }
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long personCount = 0;
        int result=0;

        // 마을 위치 및 인원 수 입력 및 초기화
        for(int i=0; i<N; i++){
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            pq.add(new Node(x,y));
            personCount += y;
        }

        // 중간 값 계산
        // 중간 값 -> 거리의 합을 최소화 하는 편차 최소화 문제에선 평균갑싱 아닌 중간값을 기반으로 계산이 되어야함.
        // 만약 평균값을 기반으로 계산할 경우, 데이터가 비대칭이거나, 극단적인 값이 있을경우 결과가 안좋게 나오게 됩니다.
        long middlePerson = (personCount+1)/2;
        long accumulatePerson = 0;

        // 우선순위 큐에서 거리 작은 순으로 빼서 계산
        while(!pq.isEmpty()){
            Node current = pq.poll();
            accumulatePerson += current.y;

            // 현재 계산된 Person값이 중간값 이상일 시, 해당 지역이 중간값이 됨.
            if(accumulatePerson >= middlePerson){
                result = current.x;
                break;
            }
        }
        System.out.println(result); // 중간값에 우체국을 놓게되면 거리의 합이 최소화 되므로 출력
    }
}