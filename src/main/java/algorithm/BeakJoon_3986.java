package algorithm;

import java.io.*;
import java.util.Stack;

public class BeakJoon_3986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i=0; i<N; i++){ // 단어의 개수만큼 반복
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(int j=0; j<s.length(); j++){ // 단어의 길이만큼 반복
                if(!stack.isEmpty() && stack.peek() == s.charAt(j)) // 만약 stack의 최상단이 현재 알파벳과 같으면 pop
                    stack.pop();
                else // 만약 stack이 비었거나, stack의 최상단이 현재 알파벳과 같지 않다면 push
                    stack.push(s.charAt(j));
            }

            if(stack.isEmpty()) // 마지막에 stack이 비었으면 '좋은 단어' 이므로 result 증가
                result++;
        }

        bw.write(Integer.toString(result));
        bw.flush();

    }
}
