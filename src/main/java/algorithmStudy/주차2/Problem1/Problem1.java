package algorithmStudy.주차2.Problem1;

import java.io.*;

//백준 1212 기존풀이
public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = br.readLine().split(""); // 8진수 입력받기

        int ten =0;
        int power =1;
        // 8진수 -> 10진수로 변환
        for(int i=numbers.length-1; i>=0; i--){
            ten += Integer.parseInt(numbers[i]) * (power);
            power*=8;
        }

        // 만약 0이라면, 예외처리
        if(ten==0){
            System.out.println("0");
            return;
        }

        // 10진수 -> 2진수로 변환
        StringBuilder sb = new StringBuilder();
        while(ten>0){
            sb.insert(0,ten%2);
            ten /= 2;
        }

        System.out.println(sb);
    }
}
