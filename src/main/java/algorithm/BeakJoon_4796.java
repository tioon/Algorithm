package algorithm;

import java.io.*;


public class BeakJoon_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int round = 1;

        while (true) {
            String[] s = br.readLine().split(" ");
            int L = Integer.parseInt(s[0]);
            int P = Integer.parseInt(s[1]);
            int V = Integer.parseInt(s[2]);
            int result = 0;

            if (L == 0 && P == 0 && V == 0)
                break;

            int vacation = V / P;
            int rev_vacation = V % P;

            if (L < rev_vacation)
                result += L;
            else
                result += rev_vacation;

            result += vacation * L;

            bw.write("Case " + round + ": " + result + '\n');
            round++;
        }

        bw.flush();
    }
}