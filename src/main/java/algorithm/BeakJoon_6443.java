package algorithm;

import java.io.*;
import java.util.*;

public class BeakJoon_6443 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 문자열 반복
        for(int i=0; i<N; i++){
            String s = br.readLine();
            char[] words = new char[s.length()];
            for(int j=0; j<s.length(); j++){
                words[j] = s.charAt(j);
            }

            Arrays.sort(words); // 문자열 오름차순 정렬 (a ~ z까지 중복된것들을 처리하기 위함)

            boolean[] visited = new boolean[s.length()]; // 방문 배열
            ArrayList<Character> list = new ArrayList<>(); // 결과 리스트

            dfs(0, words, visited, list); // dfs 시작
        }
        System.out.println(sb);
    }

    public static void dfs(int index, char[] words, boolean[] visited, ArrayList<Character> list){
        int size = words.length; // 문자열 크기 측정

        // 종료 조건
        if(index == size){
            for(int i=0;i <list.size(); i++){
                sb.append(list.get(i));
            }
            sb.append('\n');
            return;
        }

        char before = 0; // 이전에 접근했던 알파벳 저장 -> 중복으로 방문하는 걸 없애기위함.

        for(int i=0; i<size; i++) {
            if ((i == 0 || before != words[i]) && !visited[i]) {// 맨처음이거나, 이전 알파벳과 다를때만 실행
                list.add(words[i]);
                visited[i] = true;

                before = words[i]; // 접근 알파벳 반환

                dfs(index+1, words, visited, list); // 다음 dfs 실행

                visited[i] = false;
                list.remove(index);
            }
        }

    }
}