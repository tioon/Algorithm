package algorithmStudy.주차2.Problem1;

import java.io.*;

//백준 1212 기존풀이
public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = br.readLine().split("");

        int ten =0;
        int power =1;
        for(int i=numbers.length-1; i>=0; i--){
            ten += Integer.parseInt(numbers[i]) * (power);
            power*=8;
        }

        if(ten==0){
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while(ten>0){
            sb.insert(0,ten%2);
            ten /= 2;
        }

        System.out.println(sb);
    }
}
