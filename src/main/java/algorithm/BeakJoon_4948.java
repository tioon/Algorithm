package algorithm;

import java.io.*;

//백준 1027
public class BeakJoon_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            int n = Integer.parseInt(br.readLine());
            int n2 = n*2;
            int count = 0;
            boolean[] array = new boolean[n2+1];

            if(n == 0)
                break;


            /*
                에라토스테네스의 체

                1. 2부터 N까지의 모든 자연수 나열
                2. 가장 작은 수부터 선택
                3. 선택된 수의 배수를 모두 제거
                4. 계속 반복
             */
            for(int i=2; i<=n2; i++){
                if(array[i] == false){ // 아직 탐색안된 수 -> 소수임.
                    int number = i;
                    while(number <= n2){  // 배수들을 체크함.
                        array[number] = true;
                        number += i;
                    }
                    if(i>n && i<=n2) // 만약 해당 수가 범위 안에 존재한다면 count셈
                        count++;
                }
            }

            bw.write(Integer.toString(count)+'\n');
            bw.flush();
        }
    }
}