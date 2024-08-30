package algorithm;

import java.io.*;
import java.util.Arrays;

public class BeakJoon_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        String[] s1 = br.readLine().split(" ");
        for(int i=0; i<n ; i++){
            array[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        int[] array2 = new int[m];
        String[] s2 = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            array2[i] = Integer.parseInt(s2[i]);
        }

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            boolean found = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (array[mid] == array2[i]) {
                    bw.write(1 + "\n");
                    found = true;
                    break; // 일치하는 요소를 찾으면 루프를 종료
                } else if (array[mid] > array2[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (!found) {
                bw.write(0 + "\n");
            }
        }

        bw.flush();


    }
}