package algorithm;

import java.io.*;

public class BeakJoon_14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder(s);

        while(sb.length()>0){
            String word = sb.toString();
            if(word.startsWith("pi")){
                sb.delete(0,2);
            }
            else if (word.startsWith("ka")){
                sb.delete(0,2);
            }
            else if(word.startsWith("chu")){
                sb.delete(0,3);
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void removeWord(StringBuilder sb, int size){
        sb.delete(0,size-1);
    }
}