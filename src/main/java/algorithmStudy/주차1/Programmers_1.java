package algorithmStudy.주차1;

import java.util.*;

class Programmers_1{
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        //전체 숫자길이 만큼 반복
        for(int i=0; i<number.length(); i++){
            int current = Integer.parseInt(String.valueOf(number.charAt(i)));

            // 만약 K가 남아 있고, 현재값이 stack의 최상단 값보다 크다면 stack 비움
            while(k>0 && !stack.isEmpty() && stack.peek()<current){
                stack.pop();
                k--; // k값 감소
            }
            stack.push(current); // 무조건 stack에 삽입
        }

        // 여전히 k가 남아 있다면, 스택의 뒤쪽에서 k개의 숫자를 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // StringBuilder 맨앞에 삽입
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}