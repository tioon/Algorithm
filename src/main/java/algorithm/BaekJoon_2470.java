package algorithm;

import java.io.*;
import java.util.Arrays;


public class BaekJoon_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            array[i] = Integer.parseInt(s[i]);

        Arrays.sort(array);
        int start = 0;
        int end = N - 1;
        int max = Integer.MAX_VALUE;
        int[] result = new int[2];


        while (start < end) {
            int sum = array[start] + array[end];
            if (max > Math.abs(sum)) {
                result[0] = array[start];
                result[1] = array[end];
                max = Math.abs(sum);
            }
            if(sum > 0)
                end--;
            else
                start++;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
