package algorithm;

import java.io.*;

public class SCON_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String teamName = br.readLine();

            int small=0;
            int big=0;
            int high=0;

            if(teamName.length() > 10)
                continue;
            for(int j=0; j<teamName.length(); j++){
                int word = (int)teamName.charAt(j);
                if(word>=65 && word<=90)
                    big++;
                else if(word>=97 && word<=122)
                    small++;
                else if(word == 45){
                    high++;
                }
            }
            if(small+big+high == 0)
                continue;
            if(big>small)
                continue;

            sb.append(teamName).append('\n');
        }

        System.out.println(sb);
    }
}