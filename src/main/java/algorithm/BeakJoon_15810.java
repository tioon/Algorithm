package algorithm;

import java.io.*;

public class BeakJoon_15810 {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);

        int[] list = new int[n];
        String[] s2 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            int time = Integer.parseInt(s2[i]);
            list[i] = time;
        }


        // 이분 탐색 범위 설정
        long left = 0;
        long right = Long.MAX_VALUE;
        long result = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long totalBalloons = 0;

            for (int i = 0; i < n; i++) {
                totalBalloons += mid / list[i];
                if (totalBalloons >= m) break;  // 필요 개수를 초과하면 반복을 종료합니다.
            }

            // M개 이상의 풍선을 만들 수 있는가?
            if (totalBalloons >= m) {
                result = mid;  // 가능하면 시간 줄임
                right = mid - 1;
            } else {
                left = mid + 1;  // 불가능하면 시간 늘림
            }
        }

        System.out.println(result);
    }
}