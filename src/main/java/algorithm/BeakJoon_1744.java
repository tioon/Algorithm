package algorithm;

import java.io.*;
import java.util.*;

//백준_1744
public class BeakJoon_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> positives = new ArrayList<>(); // 2 이상의 수 배열
        ArrayList<Integer> negatives = new ArrayList<>(); // 0 이하의 수 배열
        int one_count = 0; // 1의 개수
        int result = 0;

        for(int i=0; i<N; i++){ //숫자 입력 받기
            int number = Integer.parseInt(br.readLine());

            if(number <= 0) // 0 이하면 negatives 배열에 저장
                negatives.add(number);
            else if(number > 1) // 2 이상이면 positives 배열에 저장
                positives.add(number);
            else //1인 경우 // 1이면 count증가
                one_count++;
        }

        Collections.sort(positives,Collections.reverseOrder()); //양수 -> 내림차순 정렬
        Collections.sort(negatives); // 음수 -> 오름차순 정렬

        for(int i=0; i<positives.size(); i++){ // 양수 배열 계산
            if(i%2==0){ // 짝수일때
                if(positives.size() > i+1)
                    result += positives.get(i)*positives.get(i+1); // 다음 수가 존재할 때 곱셈연산 수행.
                else
                    result += positives.get(i); // 다음 수가 존재하지 않으면 현재 수 더하기연산 수행.
            }
        }

        for(int i=0; i<negatives.size(); i++){ // 음수 배열 계산
            if(i%2==0){
                if(negatives.size() > i+1)
                    result += negatives.get(i)*negatives.get(i+1);// 다음 수가 존재할 때 곱셈연산 수행.
                else
                    result += negatives.get(i); // 다음 수가 존재하지 않으면 현재 수 더하기연산 수행.
            }
        }

        result += one_count; // 1의 개수 더하기

        bw.write(Integer.toString(result));
        bw.flush();

    }
}
