package algorithm;

import java.io.*;
import java.util.*;

public class BeakJoon_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 우선순위 큐

        for(int i=0; i<N; i++){
            int number = Integer.parseInt(br.readLine());
            if(number==0){
                if(queue.isEmpty()) // queue가 비어있으면 출력
                    bw.write("0\n");
                else
                    bw.write(queue.remove()+"\n"); // queue가 안비어있으면 우선순위 낮은 숫자 제거
            }
            else
                queue.add(number); // queue에 숫자 넣기
        }

        bw.flush();
    }
}

