package algorithm;

import java.io.*;
import java.util.*;

public class BeakJoon_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        //우선순위 큐 -> reverseOrder(내림차순) -> 큰값이 제일 앞으로 나오게 됨.

        for(int i=0; i<N; i++){
            int number = Integer.parseInt(br.readLine()); // 숫자 입력

            if(number==0){
                if(queue.isEmpty()) // queue가 비어 있으면 0 출력
                    bw.write("0\n");
                else
                    bw.write(queue.remove()+"\n"); // queue 안에 숫자가 있으면 숫자 출력
            }
            else
                queue.add(number); // 숫자가 입력되면 queue에 숫자 추가
        }

        bw.flush();

    }
}

