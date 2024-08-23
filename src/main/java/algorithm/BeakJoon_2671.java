package algorithm;

import java.io.*;

public class BeakJoon_2671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        if(s.matches("(100+1+|01)+"))
            System.out.println("SUBMARINE");
        else{
            System.out.println("NOISE");
        }
    }
}

// 100000111~~
/// 010101010101