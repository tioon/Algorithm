package algorithm;

import java.io.*;

//백준 2501
public class BeakJoon_2501 {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

       String[] s = br.readLine().split(" ");

       int N = Integer.parseInt(s[0]);
       int K = Integer.parseInt(s[1]);
       int count = 0;

       for(int i=1;i<N+1;i++) {  //약수 구하기
           if (N % i == 0) {  //나누어 떨어지면 count 증가
               count++;

               if (count == K)
                   bw.write(Integer.toString(i));
           }
       }

       if(count < K) //조건 충족하지 않을 시 0 출력
           bw.write("0");

       bw.flush();

       br.close();
       bw.close();
    }


}