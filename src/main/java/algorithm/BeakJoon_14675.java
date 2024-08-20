package algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BeakJoon_14675 {
    static class Node {
        int value;
        List<Node> children = new ArrayList<>();

        Node(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n+1];

        for(int i=0; i<n; i++){
            nodes[i+1] = new Node(i+1);
        }

        for(int i=0; i<n-1; i++){

            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);

            nodes[a].children.add(nodes[b]);
            nodes[b].children.add(nodes[a]);
        }

        int q = Integer.parseInt(br.readLine());

        for(int i=0; i<q; i++){
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);

            // 단절점
            if(a == 1){
                if(nodes[b].children.size() >= 2){
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }

            else if( a == 2){
                System.out.println("yes");
            }
        }
    }
}