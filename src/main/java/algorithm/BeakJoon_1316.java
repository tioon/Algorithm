package algorithm;

import java.util.Scanner;

//백준 1065
public class BeakJoon_1316 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 단어의 개수
        int count = 0; // 그룹 단어의 개수

        for (int i = 0; i < n; i++) {
            String word = scanner.next(); // 단어 입력
            boolean[] visited = new boolean[26]; // 알파벳 방문 여부를 체크할 배열

            boolean isGroupWord = true; // 그룹 단어인지 여부를 저장할 변수
            char prev = word.charAt(0); // 이전 문자를 저장할 변수

            for (int j = 1; j < word.length(); j++) {
                char current = word.charAt(j); // 현재 문자

                if (current != prev) { // 현재 문자와 이전 문자가 다른 경우
                    if (visited[current - 'a']) { // 이미 방문한 알파벳인 경우
                        isGroupWord = false; // 그룹 단어가 아님
                        break;
                    } else {
                        visited[prev - 'a'] = true; // 이전 문자를 방문했다고 체크
                        prev = current; // 이전 문자 갱신
                    }
                }
            }

            if (isGroupWord) { // 그룹 단어인 경우
                count++; // 그룹 단어 개수 증가
            }
        }

        System.out.println(count); // 그룹 단어의 개수 출력
    }
}