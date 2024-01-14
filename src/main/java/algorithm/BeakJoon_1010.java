package algorithm;

import java.io.*;

public class BeakJoon_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] a = br.readLine().split(" ");
            int N = Integer.parseInt(a[0]); // 출발지
            int M = Integer.parseInt(a[1]); // 도착지
            int result = 1;

            //nCm  (확률과 통계) - 조합법
            for(int j=1; j<=N; j++){
                result  *= M; // 곱하기
                M--;

                result /= j; // 나누기
            }

            bw.write(Integer.toString(result)+'\n');
        }

        bw.flush();

    }
}