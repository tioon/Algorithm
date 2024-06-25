package algorithm;

import java.io.*;


public class BeakJoon_2224 {
    static int N;
    static boolean[][] graph = new boolean[128][128];
    // 아스키 코드 기반의 그래프
    // A~Z, a~z 순서로 하기위해 다른방법에 비해 아스키코드로 하는 게편함 (중간생략x)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int resultCount=0;

        N = Integer.parseInt(br.readLine()); // 명제 개수 입력
        for(int i=0; i<N; i++){ // 명제 -> 그래프 업데이트
            String[] s1 = br.readLine().split(" ");
            char P = s1[0].charAt(0);
            char Q = s1[2].charAt(0);

            graph[P][Q] = true;
        }

        // 플로이드-와샬 알고리즘
        for(int k=0; k<128; k++){
            for(int i=0; i<128; i++){
                for(int j=0; j<128; j++){
                    if(graph[i][k]==true && graph[k][j]==true)
                        if(i != j)
                            graph[i][j] = true;
                }
            }
        }

        // 그래프 전체 순회하면서 조건에 맞을 때만 String Buffer에 삽입
        // 해당 반복문으로 전건 -> 후건, 대문자 -> 소문자 순으로 자동 정렬 가능
        for(int i=0; i<128; i++){
            for(int j=0; j<128; j++){
               if(i!=j && graph[i][j] == true) { // 자기자신 명제는 제외
                   resultCount++;
                   sb.append((char)i + " => " + (char)j).append('\n');
               }
            }
        }

        System.out.println(resultCount);
        System.out.println(sb.toString());
    }
}

/*5
A => B
B => C
A => D
D => B
C => D*/