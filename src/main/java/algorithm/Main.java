package algorithm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        int result=0;

        String[] s1 = br.readLine().split("");

        //문자열 반복 저장
        for(int i=0; i<s1.length; i++){
            // ')'이라면 '('가 나올때 까지 stack에 있는 숫자카운트
            if(s1[i].charAt(0) == ')'){
                while(stack.peek() != '('){
                    stack.pop();
                    result++;
                }
                stack.pop(); // '(' 삭제

                //숫자 곱하기
                int k = Integer.parseInt(String.valueOf(stack.pop()));
                result *= k;

            }
            // 그외 문자들(숫자, '(')은 바로 stack에 푸쉬
            else{
                stack.push(s1[i].charAt(0));
            }

        }

        // 마지막에 남은 숫자들 숫자 카운트
        while(!stack.isEmpty()){
            stack.pop();
            result++;
        }

        System.out.println(result);
    }
}
