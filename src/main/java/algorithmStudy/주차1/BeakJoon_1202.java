package algorithmStudy.주차1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 보석 도둑 (1주차 2번문제)
public class BeakJoon_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        int N = Integer.parseInt(s1[0]);// 보석 개수
        int K = Integer.parseInt(s1[1]);// 가방 개수

        // 보섬 무게를 기반으로 오름차순으로 우선순위 큐
        PriorityQueue<Integer[]> jewel = new PriorityQueue<>((o1, o2) -> { return o1[0]-o2[0]; });
        for(int i=0; i<N; i++){
            String[] s2 = br.readLine().split(" ");
            Integer[] value = new Integer[2];
            value[0] = Integer.parseInt(s2[0]); // 보석 무게
            value[1] = Integer.parseInt(s2[1]); // 보석 가격
            jewel.add(value);
        }

        int[] bag = new int[K];
        for(int i=0; i<K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        // 가방 무게를 기반으로 오름차순 정렬
        Arrays.sort(bag);

        // 가방에 넣을 우선순위 큐
        long answer=0;
        PriorityQueue<Integer[]> value = new PriorityQueue<>( (o1, o2) -> { return o2[1]-o1[1]; });
        for(int i=0; i<K; i++){
            int currentBag = bag[i];

            // 현재 가방 크기보다 작은 보석들은 다 우선순위 큐에 삽입
            while(!jewel.isEmpty() && jewel.peek()[0] <= currentBag){
                value.add(jewel.poll());
            }

            // 현재 우선순위 큐에 있는 것중 가장 큰 value 더하기
            if(!value.isEmpty())
                answer += value.poll()[1];

        }

        System.out.println(answer);

    }
}