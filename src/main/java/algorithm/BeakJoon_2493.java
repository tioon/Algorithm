package algorithm;

import java.io.*;
import java.util.Stack;


public class BeakJoon_2493 {
    static class Node{
        int height; // 탑의 높이
        int N; // 탑의 위치

        Node(int height, int N){ // 탑 노드 생성자
            this.height = height;
            this.N = N;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        Stack<Node> stack = new Stack<>();

        for(int i=0; i<s.length; i++){
            Node newNode = new Node(Integer.parseInt(s[i]),i+1); // 해당 탑의 정보 생성

            while(!stack.isEmpty() && stack.peek().height < newNode.height){ // stack의 최상단Node의 높이값 < 현재 Node의 높이값 일 경우, stack에서 뺌
                stack.pop();
            }

            if(stack.isEmpty()) // stack이 비어 있다면, 자신보다 큰 탑이 없다는 의미로, 0 으로 출력
                bw.write("0 ");
            else{ // stack이 비어있지 않으면, 자신보다 큰 탑이 있다는 의미로, 해당 탑의 위치정보 출력
                bw.write(Integer.toString(stack.peek().N)+" ");
            }

            stack.push(newNode); // 현재 Node를 stack에 push함.

        }

        bw.flush();
    }
}

// 6 10 8 5 7 19