package algorithm;

import java.io.*;
import java.util.ArrayList;

public class BeakJoon_9934 {
    static String[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");

        ArrayList<Integer>[] lists = new ArrayList[K];
        for (int i = 0; i < K; i++)
            lists[i] = new ArrayList<>();

        // 이분탐색
        binarySearch(0, (int) Math.pow(2, K) - 1, 0, lists, K);

        // 배열 탐색
        for (ArrayList<Integer> list : lists) {
            for (Integer num : list) {
                bw.write(num + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 이분탐색 메서드 (시작값, 끝값, 현재 트리 깊이, 2차원 저장 리스트, 입력 트리깊이)
    public static void binarySearch(int start, int end, int depth, ArrayList<Integer>[] lists, int K) {
        // 트리 깊이가 최대치 도달시, 중단
        if (depth == K)
            return;


        int mid = (start + end) / 2; // 가운데값 가져오기
        lists[depth].add(Integer.parseInt(s[mid])); // 현재 깊이의 리스트에 가운데값 저장
        binarySearch(start, mid - 1, depth + 1, lists, K); // 좌측 이분탐색
        binarySearch(mid + 1, end, depth + 1, lists, K); // 우측 이분탐색
    }
}