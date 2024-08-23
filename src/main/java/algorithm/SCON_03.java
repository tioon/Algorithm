package algorithm;

import java.io.*;

public class SCON_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");

        StringBuilder first = new StringBuilder();
        for(int i=0; i<s1.length; i++){
            first.append(s1[i]);
        }

        StringBuilder second = new StringBuilder();
        for(int i=0; i<s2.length; i++){
            second.append(s2[i]);
        }

        long one = Long.parseLong(String.valueOf(first));
        long two = Long.parseLong(String.valueOf(second));

        System.out.println(Long.min(one,two));
    }
}