package algorithm;

import java.io.*;
import java.util.*;

public class BeakJoon_20116 {
    static int n;
    static int L;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        L = Integer.parseInt(s1[1]);

        String[] s2 = br.readLine().split(" ");
        for(String box : s2) {
            stack.push(Integer.parseInt(box));
        }

        long sum = 0;
        int count = 0;

        while(stack.size() > 1) {
            int currentBox = stack.pop();
            sum += currentBox;
            count++;

            double average = (double)sum / count;
            int nextBox = stack.peek();

            if(Math.abs(average - nextBox) >= L) {
                System.out.println("unstable");
                return;
            }
        }

        System.out.println("stable");
    }
}
// stack에 사각형들 넣기.
// stack 크기 1일때까지 반복. (while문)
// 무게중심 구하기 -> 1. 지금까지의 무게중심 + 다음 상자의 범위 (무게중심 안맞을 경우 끝)
// stack에 하나 남았을떄는 그냥 버려도됨. 굳이 상관 x