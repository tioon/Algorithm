package algorithm;

import java.io.*;

public class BeakJoon_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        int[][] array = new int[N + 1][N + 1]; // 입력 배열
        int[][] arraySum = new int[N + 1][N + 1]; // 누적 합 배열

        // 배열 값 입력 및 누적 합 배열 구성
        for (int i = 1; i <= N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                array[i][j] = Integer.parseInt(row[j - 1]);
                arraySum[i][j] = arraySum[i - 1][j] + arraySum[i][j - 1] - arraySum[i - 1][j - 1] + array[i][j];
                // 누적합 = 이전 가로 누적합 + 이전 세로 누적합 - 이전 누적 중복값 + 현재값;
            }
        }

        // 구간 합 계산
        for (int i = 0; i < M; i++) {
            String[] range = br.readLine().split(" ");
            int startY = Integer.parseInt(range[0]);
            int startX = Integer.parseInt(range[1]); // 시작 주소
            int endY = Integer.parseInt(range[2]);
            int endX = Integer.parseInt(range[3]); // 도착 주소

            int result = arraySum[endY][endX] - arraySum[startY - 1][endX] - arraySum[endY][startX - 1] + arraySum[startY - 1][startX - 1];
            // 현재값 = 도착지 누적합 - 가로 제외 누적합 - 세로 제외 누적합 + 중복된 제외값

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
