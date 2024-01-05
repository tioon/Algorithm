package algorithm;

import java.io.*;

//백준_16953
public class BeakJoon_16953 {
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);

        Calculation(A,B,1);

        if(result ==Integer.MAX_VALUE)
            bw.write("-1");
        else
            bw.write(Integer.toString(result));
        bw.flush();

    }

    static void Calculation(int start,int end, int count){

        if(start==end) {
            result = Math.min(result, count);
            return;
        }

        if(start*10+1 <= end)
            Calculation(start*10+1, end,count+1);
        if(start*2 <= end)
            Calculation(start*2, end,count+1);

    }

}