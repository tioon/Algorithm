package algorithm;

import java.io.*;

public class BaekJoon_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int N = Integer.parseInt(s);
        int[] array = new int[N+1];

        //처음부터 해당 숫자까지 반복
        for(int i=1;i<N+1;i++){
            if(i == 1) // 맨 처음 1일땐 배열에 1저장
                array[1] = 1;
            else{ //2 이상일 땐, 그전 배열값 + 현재 체크값
                array[i] = array[i-1] + check(Integer.toString(i));
            }
        }


        bw.write(Integer.toString(array[N])); // 출력
        bw.flush();
    }


    static int check(String s){ //체크 함수

        if(s.length() == 1) //한 자리 수는 1 return
            return 1;

        int number = s.charAt(0) - s.charAt(1); // 공차 구하는 식

        for(int i=2;i<s.length();i++){
            if(number != s.charAt(i-1) - s.charAt(i))  //공차가 일정하지 않으면 0 return
                return 0;
        }

        return 1;
    }
}