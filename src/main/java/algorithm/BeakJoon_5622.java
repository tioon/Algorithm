package algorithm;

import java.io.*;
import java.util.*;


public class BeakJoon_5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, Integer> dialMap = new HashMap<>();
        // 다이얼 누르는데 필요한 시간을 HashMap에 저장
        dialMap.put('A', 3);
        dialMap.put('B', 3);
        dialMap.put('C', 3);
        dialMap.put('D', 4);
        dialMap.put('E', 4);
        dialMap.put('F', 4);
        dialMap.put('G', 5);
        dialMap.put('H', 5);
        dialMap.put('I', 5);
        dialMap.put('J', 6);
        dialMap.put('K', 6);
        dialMap.put('L', 6);
        dialMap.put('M', 7);
        dialMap.put('N', 7);
        dialMap.put('O', 7);
        dialMap.put('P', 8);
        dialMap.put('Q', 8);
        dialMap.put('R', 8);
        dialMap.put('S', 8);
        dialMap.put('T', 9);
        dialMap.put('U', 9);
        dialMap.put('V', 9);
        dialMap.put('W', 10);
        dialMap.put('X', 10);
        dialMap.put('Y', 10);
        dialMap.put('Z', 10);

        String[] input = br.readLine().split("");

        int totalTime = 0;
        for (int i = 0; i < input.length; i++) {
            char c = input[i].charAt(0);
            int time = dialMap.get(c); // 각 문자에 대한 누르는데 필요한 시간을 가져옴
            totalTime += time;
        }

        System.out.println(totalTime);
    }
}
