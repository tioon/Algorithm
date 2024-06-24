package algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BeakJoon_11265 {
    static class Customer{ // 손님 객체
        int start; // 시작점
        int end; // 끝점
        int time; // 걸리는 시간 (distance)

        Customer(int start, int end, int time){
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        int N = Integer.parseInt(s1[0]); // 파티장 크기
        int M = Integer.parseInt(s1[1]); // 요청 손님 수
        int[][] graph = new int[N+1][N+1];
        List<Customer> customers = new ArrayList<>(); // 손님 객체 리스트 (M개의 손님의 요청이 들어옴)

        for(int i=1; i<N+1; i++){ // 그래프 입력 로직
            String[] s2 = br.readLine().split(" ");
            for(int j=1; j<N+1; j++){
                graph[i][j] = Integer.parseInt(s2[j-1]);
            }
        }

        for(int i=0; i<M; i++){ // 손님 객체 입력 로직
            String[] s3 = br.readLine().split(" ");
            int start = Integer.parseInt(s3[0]);
            int end = Integer.parseInt(s3[1]);
            int time = Integer.parseInt(s3[2]);
            customers.add(new Customer(start, end, time));
        }

        // 플로이드-워셜 알고리즘
        for(int i=1; i<N+1; i++){ // 중간 경유지
            for(int j=1; j<N+1; j++){ // 시작점
                for(int k=1; k<N+1; k++){ // 끝점
                    if(graph[j][k] > graph[j][i] + graph[i][k])
                        graph[j][k] = graph[j][i] + graph[i][k]; // 중간 경유를하는게 더 빠를경우, graph 업데이트
                }
            }
        }

        for(int i=0; i<M; i++){
            Customer customer= customers.get(i); // 손님 객체 가져오기
            int start = customer.start;
            int end = customer.end;
            int time = customer.time;
            if(graph[start][end] <= time) // 기준점에 알맞다면 party 가기
                System.out.println("Enjoy other party");
            else // 기준점에 알맞지 않다면 머물기
                System.out.println("Stay here");
        }
    }
}