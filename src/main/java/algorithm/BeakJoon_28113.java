package algorithm;

import java.io.*;

//백준 1065
public class BeakJoon_28113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s= br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int A = Integer.parseInt(s[1]);
        int B = Integer.parseInt(s[2]);

        int Bus = A;
        int Subway;

        if(N <= B)
            Subway = B;
        else
            Subway = Integer.MAX_VALUE;

        if(Bus > Subway)
            bw.write("Subway");
        else if(Bus < Subway)
            bw.write("Bus");
        else
            bw.write("Anything");
        bw.flush();

    }
}