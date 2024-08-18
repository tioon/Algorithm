package algorithm;

import java.io.*;
import java.util.PriorityQueue;

public class BeakJoon_1487 {
    static class Node implements Comparable<Node>{
        int price;
        int fee;

        Node(int price, int fee){
            this.price = price;
            this.fee = fee;
        }

        @Override
        public int compareTo(Node o){
            return this.price - o.price;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            String[] s1 = br.readLine().split(" ");
            int price = Integer.parseInt(s1[0]);
            int fee = Integer.parseInt(s1[1]);

            pq.add(new Node(price,fee));
        }

        int[] sum = new int[n];
        int[] price = new int[n];
        int current=0;
        int currentMax;
        while(!pq.isEmpty()){
            Node currentNode = pq.poll();
            int currentPrice = currentNode.price;
            int currentFee = currentNode.fee;

            sum[current] = Math.max(0, currentPrice-currentFee);
            price[current] = currentPrice;
            for(int i=0; i<current; i++){
                sum[i] += Math.max(0, price[i]-currentFee);
            }
            current++;
        }

        int max=0;
        int result=0;
        for(int i=0; i<n; i++){
            //System.out.println(sum[i]+ " "+price[i]);
            if(max < sum[i]) {
                max = sum[i];
                result = price[i];
            }
        }

        System.out.println(result);


    }
}