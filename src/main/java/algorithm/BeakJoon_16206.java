package algorithm;

import java.io.*;
import java.util.PriorityQueue;

public class BeakJoon_16206 {
    static class Node implements Comparable<Node>{
        int value;

        Node(int value){
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            // 10으로 나누어 떨어지는지 여부를 먼저 비교
            if ((this.value % 10 == 0) && (o.value % 10 != 0)) {
                return -1; // this가 우선순위가 높음
            } else if ((this.value % 10 != 0) && (o.value % 10 == 0)) {
                return 1; // o가 우선순위가 높음
            }
            // 둘 다 10으로 나누어 떨어지거나, 둘 다 나누어 떨어지지 않는 경우
            return Integer.compare(this.value, o.value); // 값 자체를 비교
        }
    }

    static int n;
    static int m;
    static PriorityQueue<Node> pq;
    static int count;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        pq = new PriorityQueue<>();

        String[] s2 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            pq.add(new Node(Integer.parseInt(s2[i])));
        }

        while(count < m && !pq.isEmpty()){
            Node current = pq.poll();

            if(current.value == 10){
                result++;
            }
            else if(current.value % 10 == 0){
                result++;
                count++;
                pq.add(new Node(current.value-10));
            }
            else{
                if(current.value > 10){
                    count++;
                    result++;
                    pq.add(new Node(current.value-10));
                } else {

                }
            }
            //System.out.println(current.value+ " " + result +" " +count);
        }

        while(!pq.isEmpty()) {
            if (pq.poll().value != 10) {
                break;
            } else
                result++;
        }

        System.out.println(result);
    }
}

//10  -> 1 0
//20  -> 2 1
//30  -> 3 2
//40  -> 4 3