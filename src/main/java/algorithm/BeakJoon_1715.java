package algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BeakJoon_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        Integer[] cards = new Integer[N];
        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cards, Collections.reverseOrder());
        for(int card : cards)
            pq.add(card);

        int sum=0;
        while(pq.size() != 1){
            int a = pq.poll();
            int b = pq.poll();
            sum += a+b;
            pq.add(a+b);
        }
        System.out.println(sum);
    }
}

//20 50 60