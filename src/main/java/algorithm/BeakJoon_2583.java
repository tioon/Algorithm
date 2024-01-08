package algorithm;

import java.io.*;
import java.util.*;

//백준 1065
public class BeakJoon_2583 {
    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int M = Integer.parseInt(s[0]); // 세로
        int N = Integer.parseInt(s[1]); // 가로
        int K = Integer.parseInt(s[2]); // 직사각형 개수

        int[][] array = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        int result=0;

        for(int i=0; i<K; i++){
            String[] a = br.readLine().split(" ");
            int start_x = Integer.parseInt(a[0]); // 직사각형 시작 지점
            int start_y = Integer.parseInt(a[1]);
            int end_x = Integer.parseInt(a[2]); // 직사각형 종료 지점
            int end_y = Integer.parseInt(a[3]);

            for(int j=start_x; j<end_x; j++){
                for(int k=start_y; k<end_y; k++){
                    array[k][j] = 1; // 직사각형의 범위에 1 표시.
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int j=0; j<M; j++){
            for(int k=0; k<N; k++){
                if(array[j][k]==0 && visited[j][k]==false) { // 아직 방문하지 않은 빈 구역일 시 bfs진행
                    list.add(bfs(k, j, array, visited)); // 배열에 해당 빈 구역 넓이 추가
                    result++;
                }
            }
        }

        Collections.sort(list); // 빈 구역 넓이 배열 정렬

        bw.write(Integer.toString(result)+'\n');
        for(int i=0; i<list.size(); i++){
            bw.write(Integer.toString(list.get(i))+" "); // 빈 구역 넓이 출력
        }

        bw.flush();


    }

    static int bfs(int x, int y,int[][] array, boolean[][] visited){
        int[] x_p = {-1,1,0,0};
        int[] y_p = {0,0,-1,1};
        int count=0;

        Stack<Node> stack = new Stack<>();

        stack.push(new Node(x,y)); // 시작점 stack에 push
        visited[y][x] = true;

        while(!stack.isEmpty()){
            Node current = stack.pop();
            count++;

            for(int i=0; i<4; i++){
                int x_k = current.x+x_p[i];
                int y_k = current.y+y_p[i];
                if(x_k>=0 && x_k<array[0].length && y_k>=0 && y_k<array.length){ // 전체 직사각형 범위 넘어가지 않도록 처리
                    if(array[y_k][x_k]==0 && visited[y_k][x_k]==false){ // 빈 구역이고, 아직 방문하지 않았을 시, stack에 push
                        stack.push(new Node(x_k,y_k));
                        visited[y_k][x_k] = true;
                    }
                }
            }
        }
        return count;

    }
}