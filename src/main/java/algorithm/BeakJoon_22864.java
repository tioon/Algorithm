package algorithm;

import java.io.*;
import java.util.Arrays;

public class BeakJoon_22864 {
    static int A;
    static int B;
    static int C;
    static int M;
    static int result=0;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        A = Integer.parseInt(s1[0]); // 일 진행시 피로도 수치
        B = Integer.parseInt(s1[1]); // 일 진행시 업무량
        C = Integer.parseInt(s1[2]); // 휴식시 피로도 감소 수치
        M = Integer.parseInt(s1[3]); // 번아웃 수치

        int tired=0;
        int sum=0;

        dp = new int[25][M + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        result = dfs(tired, sum, 1);

        System.out.println(result);

    }

    public static int dfs(int tired, int sum, int current){
        if(current>24){
            return sum;
        }

        if(dp[current][tired] != -1)
            return dp[current][tired];

        int work = 0;
        int rest = 0;

        if(tired+A <= M){ // 일이 가능할 때,
            work = dfs(tired+A, sum+B, current+1); // 일 진행
        }
        rest = dfs(Math.max(tired-C,0), sum, current+1); // 휴식 진행

        dp[current][tired] = Math.max(work, rest);
        return dp[current][tired];
    }

}