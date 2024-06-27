package algorithm;

import java.io.*;

public class BeakJoon_2615 {
    static int[][] graph = new int[20][20];
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i < 20; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 1; j < 20; j++) {
                graph[i][j] = Integer.parseInt(s1[j - 1]);
            }
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if (graph[i][j] != 0) {
                    int value = graph[i][j];
                    if (dfs_right(value, i, j, 1)) {
                        System.out.println(sb);
                        return;
                    }
                    if (dfs_down(value, i, j, 1)) {
                        System.out.println(sb);
                        return;
                    }
                    if (dfs_right_down(value, i, j, 1)) {
                        System.out.println(sb);
                        return;
                    }
                    if (dfs_right_up(value, i, j, 1)) {
                        System.out.println(sb);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    public static boolean dfs_right(int value, int i, int j, int index) {
        if (index == 5) { // 현재가 오목일 때만 발동
            if (j + 1 < 20 && graph[i][j + 1] == value) return false; // 오른쪽 육목 체크
            if (j - 5 > 0 && graph[i][j - 5] == value) return false; // 왼쪽 육목 체크
            sb.append(value).append('\n').append(i).append(' ').append(j - 4);
            return true;
        }
        if (j + 1 < 20 && graph[i][j + 1] == value) {// 오른쪽에 같은 돌이 있을 때
            return dfs_right(value, i, j + 1, index + 1);
        }
        return false;
    }

    public static boolean dfs_down(int value, int i, int j, int index) {
        if (index == 5) { // 현재가 오목일 때만 발동
            if (i + 1 < 20 && graph[i + 1][j] == value) return false; // 아래쪽 육목 체크
            if (i - 5 > 0 && graph[i - 5][j] == value) return false; // 위쪽 육목 체크
            sb.append(value).append('\n').append(i - 4).append(' ').append(j);
            return true;
        }
        if (i + 1 < 20 && graph[i + 1][j] == value) { // 아래쪽에 같은 돌이 있을 때
            return dfs_down(value, i + 1, j, index + 1);
        }
        return false;
    }

    public static boolean dfs_right_down(int value, int i, int j, int index) {
        if (index == 5) {
            if (i + 1 < 20 && j + 1 < 20 && graph[i + 1][j + 1] == value) return false; // 오른쪽 아래 육목 체크
            if (i - 5 > 0 && j - 5 > 0 && graph[i - 5][j - 5] == value) return false; // 왼쪽 위 육목 체크
            sb.append(value).append('\n').append(i - 4).append(' ').append(j - 4);
            return true;
        }
        if (i + 1 < 20 && j + 1 < 20 && graph[i + 1][j + 1] == value) {
            return dfs_right_down(value, i + 1, j + 1, index + 1);
        }
        return false;
    }

    public static boolean dfs_right_up(int value, int i, int j, int index) {
        if (index == 5) {
            if (i - 1 > 0 && j + 1 < 20 && graph[i - 1][j + 1] == value) return false; // 오른쪽 위 육목 체크
            if (i + 5 < 20 && j - 5 > 0 && graph[i + 5][j - 5] == value) return false; // 왼쪽 아래 육목 체크
            sb.append(value).append('\n').append(i + 4).append(' ').append(j - 4);
            return true;
        }
        if (i - 1 > 0 && j + 1 < 20 && graph[i - 1][j + 1] == value) {
            return dfs_right_up(value, i - 1, j + 1, index + 1);
        }
        return false;
    }
}
