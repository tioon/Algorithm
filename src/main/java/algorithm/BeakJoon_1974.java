package algorithm;

import java.io.*;

public class BeakJoon_1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] array = new long[N+1];

        for(int i=1; i<=N; i++){
            if(i==1) // 처음은 1
                array[i] = 1;
            else if(i==2) // 두번째는 2
                array[i] = 2;
            else
                array[i] = (array[i-2] + array[i-1])%15746; // 그 이후에는 피보나치와 동일한 점화식을가짐 ->  N = (N-1) + (N-2)
        }

        bw.write(Long.toString(array[N])); // 결과 출력
        bw.flush();
    }
}
