package algorithm;

import java.io.*;

public class BeakJoon_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] prefixSum = new int[26][S.length()];

        prefixSum[S.charAt(0)-'a'][0] = 1;
        for(int i=1; i<S.length(); i++){
            int alphabet = S.charAt(i) - 'a';

            for(int j=0; j<26; j++){
                if(j == alphabet)
                    prefixSum[j][i] = prefixSum[j][i-1] + 1;
                else
                    prefixSum[j][i] = prefixSum[j][i-1];
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q; i++){
            String[] s1 = br.readLine().split(" ");
            int alphabet = s1[0].charAt(0) - 'a';
            int start = Integer.parseInt(s1[1]);
            int end = Integer.parseInt(s1[2]);

            if(start == 0)
                sb.append(prefixSum[alphabet][end]).append('\n');
            else
                sb.append(prefixSum[alphabet][end] - prefixSum[alphabet][start-1]).append('\n');
        }

        System.out.print(sb);

    }
}