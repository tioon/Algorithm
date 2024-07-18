package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_12871 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        String t=br.readLine();

        StringBuilder ss=new StringBuilder(s);
        StringBuilder tt=new StringBuilder(t);

        int sLen=s.length();
        int tLen=t.length();

        int lcm=(sLen*tLen)/gcd(Math.max(sLen, tLen),Math.min(sLen, tLen));

        for(int i=0; i<lcm/sLen-1; i++) {
            ss.append(s);
        }
        for(int i=0; i<lcm/tLen-1; i++) {
            tt.append(t);
        }

        int result= (ss.toString().equals(tt.toString())) ? 1:0;
        System.out.println(result);

    }

    private static int gcd(int max, int min) {

        while(min!=0) {
            int remainder=max%min;
            max=min;
            min=remainder;
        }
        return max;
    }

}