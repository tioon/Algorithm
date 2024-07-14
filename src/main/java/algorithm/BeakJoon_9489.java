package algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.*;

class Node{
    int value;
    int parent;
    List<Node> child;

    Node(int value){
        this.value = value;
        this.child = new ArrayList<>();
    }
}

public class BeakJoon_9489 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String[] s1 = br.readLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            int k = Integer.parseInt(s1[1]);

            if(n==0 && k==0)
                break;

            String[] s2 = br.readLine().split(" ");
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = Integer.parseInt(s2[i]);

            HashMap<Integer, Node> map = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();

            //루트 노드 삽입
            map.put(array[0], new Node(array[0]));
            queue.add(array[0]);

            Node node = null;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] + 1 != array[i]) { // 연속된 숫자가 아니라면
                    node = map.get(queue.poll()); // 부모노드 가져오기
                }

                Node current = new Node(array[i]); // 현재 노드 생성
                current.parent = node.value; // 현재노드에 부모 설정
                node.child.add(current); // 부모노드에 현재 자식 넣기

                map.put(array[i], current);
                queue.add(array[i]);
            }

            System.out.println(findCousin(map, queue, k));
        }

    }

    public static int findCousin(HashMap<Integer,Node> map, Queue<Integer> queue, int k){
        Node my = map.get(k);
        if(my.parent == 0) return 0;
        Node parent = map.get(my.parent);
        if(parent.parent ==0) return 0;
        Node grandParent = map.get(parent.parent);

        int siblingCount=0;

        List<Node> child =grandParent.child;
        for(int i=0; i< child.size(); i++){
            Node node = child.get(i);

            if(!node.equals(parent)){
                siblingCount += node.child.size();
            }
        }

        return siblingCount;
    }
}


// 1. Queue에 삽입 / 노드 생성
// 2. 연속된 수인지 체크 / 연속된 수라면 그냥 노드 생성 or 연속된 수가 아니라면 Queue에서 노드 빼고 자식으로 연결
// 3.