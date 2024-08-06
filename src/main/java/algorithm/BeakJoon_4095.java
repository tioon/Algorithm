package algorithm;

import java.util.Scanner;

public class BeakJoon_4095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;
            int[][] array = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    array[i][j] = sc.nextInt();
                }
            }
            System.out.println(maxSquareSum(array, n, m));
        }
        sc.close();
    }

    public static int maxSquareSum(int[][] array, int n, int m) {
        int[][] dp = new int[n][m];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = array[i][j];
                if (i > 0 && j > 0 && array[i][j] > 0) {
                    dp[i][j] = array[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
                if (dp[i][j] > maxSum) {
                    maxSum = dp[i][j];
                }
            }
        }

        return maxSum;
    }
}
