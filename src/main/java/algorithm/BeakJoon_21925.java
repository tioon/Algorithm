package algorithm;

import java.io.*;
import java.util.Stack;

public class BeakJoon_21925 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(s1[i]);
        }

        Stack<Integer> stack = new Stack<>();
        boolean check = true;

        for (int i = 0; i < N; i++) {
            int num = array[i];

            if (stack.empty() || stack.peek() != num)
                stack.push(num);
            else { // 만약 팰린드롬이 맞다면
                check = checkNumber(stack, array, i);

                if(check) {
                    i+=stack.size()-1;
                    stack.clear();
                    count++;
                }
                else stack.push(num);
            }
        }

        if (check == true)
            System.out.println(count);
        else
            System.out.println(-1);
    }

    public static boolean checkNumber(Stack<Integer> stack, int[] array, int i) {
        int stackSize = stack.size();
        if(stackSize + i > array.length)
            return false;

        for (int j = i; j < i + stackSize; j++) {
            //System.out.println(j+" "+i+" "+stackSize);
            if (array[j] != stack.get(stackSize-1 - (j-i)))
                return false;
        }
        return true;
    }
}
