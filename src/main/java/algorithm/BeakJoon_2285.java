package algorithm;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int location;
    int people;

    Node(int location, int people){
        this.location = location;
        this.people = people;
    }

    @Override
    public int compareTo(Node other){
        return Integer.compare(this.location, other.location);
    }

    @Override
    public String toString() {
        return "Node{" + "location=" + location + ", people=" + people + '}';
    }
}

public class BeakJoon_2285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Node> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        long totalPeople = 0;

        for(int i=0; i<N; i++){
            String[] s1 = br.readLine().split(" ");
            int location = Integer.parseInt(s1[0]);
            int people = Integer.parseInt(s1[1]);
            list.add(new Node(location, people));
            totalPeople += people;
        }

        // 마을을 위치 기준으로 정렬
        list.sort(Comparator.comparingInt(node -> node.location));

        // 전체 인구의 절반을 넘는 위치를 찾기
        long halfPeople = (totalPeople + 1) / 2; // 전체 인구의 절반 이상이 되도록
        long cumulativePeople = 0;

        for (Node node : list) {
            cumulativePeople += node.people;
            if (cumulativePeople >= halfPeople) {
                System.out.println(node.location);
                break;
            }
        }

        br.close();
        bw.close();
    }
}
