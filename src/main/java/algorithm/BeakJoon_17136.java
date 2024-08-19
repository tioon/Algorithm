package algorithm;

import java.io.*;

public class BeakJoon_17136 {
    static int[][] board = new int[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5}; // 색종이 개수 (크기별로 5장씩)
    static int minCount = Integer.MAX_VALUE; // 최소 색종이 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 10x10 격자 입력
        for (int i = 0; i < 10; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        // DFS 시작
        dfs(0, 0, 0);

        // 결과 출력
        if (minCount == Integer.MAX_VALUE) {
            System.out.println(-1); // 모든 1을 덮을 수 없는 경우
        } else {
            System.out.println(minCount); // 최소 색종이 수 출력
        }
    }

    // DFS로 백트래킹 수행
    static void dfs(int x, int y, int count) {
        if (x >= 10) { // 모든 행을 다 탐색했을 때
            minCount = Math.min(minCount, count); // 최소 색종이 수 갱신
            return;
        }

        if (y >= 10) { // 현재 행을 다 탐색했을 때, 다음 행으로 이동
            dfs(x + 1, 0, count);
            return;
        }

        if (board[x][y] == 1) { // 현재 위치에 1이 있으면
            for (int size = 5; size >= 1; size--) { // 큰 색종이부터 시도
                if (canAttach(x, y, size)) { // 색종이 붙일 수 있으면
                    attach(x, y, size, 0); // 색종이 붙이기
                    paper[size]--; // 색종이 개수 감소
                    dfs(x, y + 1, count + 1); // 다음 위치로 이동
                    attach(x, y, size, 1); // 색종이 떼기
                    paper[size]++; // 색종이 개수 복구
                }
            }
        } else { // 현재 위치에 1이 없으면 다음 위치로 이동
            dfs(x, y + 1, count);
        }
    }

    // 색종이를 붙일 수 있는지 확인
    static boolean canAttach(int x, int y, int size) {
        if (paper[size] == 0) return false; // 해당 크기 색종이가 남아있는지 확인

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (x + i >= 10 || y + j >= 10 || board[x + i][y + j] == 0) { // 범위를 넘거나 0인 경우
                    return false;
                }
            }
        }
        return true;
    }

    // 색종이를 붙이거나 떼는 함수
    static void attach(int x, int y, int size, int state) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[x + i][y + j] = state;
            }
        }
    }
}