package algorithm;

import java.io.*;
import java.util.*;

public class BeakJoon_28115 {
    static int N;
    static long[] A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new long[N + 1];
        B = new long[N + 1];
        C = new long[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        if (N <= 2 || (N >= 3 && A[2]*2 == A[1] + A[3])) {
            System.out.println("YES");
            for (int i = 1; i <= N; i++) {
                System.out.print((2*A[i]) + " ");
            }
            System.out.println();
            for (int i = 1; i <= N; i++) {
                System.out.print((-A[i]) + " ");
            }
        } else {
            System.out.println("NO");
        }
    }
}
