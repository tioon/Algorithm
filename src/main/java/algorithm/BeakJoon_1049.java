package algorithm;

import java.io.*;
import java.util.*;

//백준_1049
public class BeakJoon_1049 {
    static class Rope{ // Rope 클래스
        int six;
        int one;

        Rope(int six, int one){
            this.six = six;
            this.one = one;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        ArrayList<Rope> list = new ArrayList<>(); // Rope 리스트

        for (int i = 0; i < M; i++) {
            String[] a = br.readLine().split(" ");
            list.add(new Rope(Integer.parseInt(a[0]), Integer.parseInt(a[1])));
        }

        int min_six = Integer.MAX_VALUE; // 6개묶음 최솟값
        int min_one = Integer.MAX_VALUE; // 1개 최솟값
        int result = 0;

        for (Rope rope : list) { // 리스트 반복
            if (rope.six < min_six)
                min_six = rope.six; // 6개 묶음 최솟값 업데이트
            if (rope.one < min_one)
                min_one = rope.one; // 1개 최솟값 업데이트
        }

        while (N > 6) { // 6개 묶음 될때까지 반복
            result += Math.min(min_six, min_one * 6); // 6개묶음, 1개씩 6번구매 중 최소값으로 계산
            N -= 6;
        }
        result += Math.min(min_six, min_one * N); // 남은거 최소값 계산

        bw.write(Integer.toString(result));
        bw.flush();
    }
}