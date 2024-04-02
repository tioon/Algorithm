package algorithm;

import java.io.*;


public class BeakJoon_1965 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;

        int n = Integer.parseInt(br.readLine());
        int[] box = new int[n];

        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++)
            box[i] = Integer.parseInt(s[i]);

        int[] max = new int[n];

        for(int i=0; i<n; i++){
            max[i]=1; // 기본값으로는 1임

            for(int j=0; j<i; j++){ // 자기보다 왼쪽의 box에 작은게 있는지 확인
                if(box[i] > box[j] ) {
                    max[i] = Math.max(max[i], max[j] + 1); // 현재의 max와 해당 box의 max를 비교
                }
            }

            result = Math.max(result, max[i]); // 최대값인지 비교후 업데이트
        }

        bw.write(Integer.toString(result));
        bw.flush();
    }
}