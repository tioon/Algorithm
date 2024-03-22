package algorithm;

import java.io.*;
import java.util.*;


public class BeakJoon_1991 {
    // 트리 노드 클래스
    public static class Node{
        char value;
        Node left;
        Node right;

        public Node (){}

        public void setValue(char value){
            this.value = value;
        }
        public void setLeft(Node left){
            this.left = left;
        }
        public void setRight(Node right){
            this.right = right;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Character> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N+1]; // 노드 생성자
        for(int i=1; i<N+1; i++)
            nodes[i] = new Node();

        for(int i=1; i<N+1; i++){
            String[] s = br.readLine().split(" ");

            // 아스키 코드 기준 'A'가 65임.
            // 따라서, 64를 기준으로 index 처리를 하여 배열에 적용함. (ex A=1, B=2, C=3....)
            int startNode = s[0].charAt(0) - 64;
            int endLnode = s[1].charAt(0) - 64;
            int endRnode = s[2].charAt(0) - 64;

            // 해당 노드에 startNode값을 넣음
            nodes[startNode].setValue(s[0].charAt(0));

            // '.'은 46임. 따라서 64 기준으로 index 처리 했을때 음수가 나옴.
            // 따라서, 음수인 경우 제외하고 양수인 경우만 처리함.
            if(endLnode > 0)
                nodes[startNode].setLeft(nodes[endLnode]); // 왼쪽 노드 추가
            if(endRnode > 0)
                nodes[startNode].setRight(nodes[endRnode]); // 오른쪽 노드 추가

        }

        // 전위 순회 (preorder)
        preorder(nodes[1], queue);
        while(!queue.isEmpty())
            bw.write(queue.poll());
        bw.write('\n');

        // 중위 순회 (inorder)
        inorder(nodes[1], queue);
        while(!queue.isEmpty())
            bw.write(queue.poll());
        bw.write('\n');

        // 후위 순회 (postorder)
        postorder(nodes[1], queue);
        while(!queue.isEmpty())
            bw.write(queue.poll());


        bw.flush();


    }


    public static void preorder(Node node ,Queue<Character> queue){
        queue.add(node.value);

        if(node.left != null)
            preorder(node.left, queue);

        if(node.right != null)
            preorder(node.right, queue);
    }

    public static void inorder(Node node ,Queue<Character> queue){

        if(node.left != null)
            inorder(node.left, queue);

        queue.add(node.value);

        if(node.right != null)
            inorder(node.right, queue);
    }

    public static void postorder(Node node ,Queue<Character> queue){

        if(node.left != null)
            postorder(node.left, queue);

        if(node.right != null)
            postorder(node.right, queue);

        queue.add(node.value);
    }
}