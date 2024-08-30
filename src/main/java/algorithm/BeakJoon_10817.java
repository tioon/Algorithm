package algorithm;

import java.io.*;
import java.util.Arrays;

public class BeakJoon_10817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        int[] cards = new int[n];
        for(int i=0; i<n; i++){
            cards[i] = Integer.parseInt(s1[i]);
        }

        int m = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");
        int[] array = new int[m];
        for(int i=0; i<m; i++){
            array[i] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(cards);

        for(int i=0; i<m; i++){
            int left = 0;
            int right = cards.length;
            int mid;

            boolean found=false;

            while(left<=right){
                mid = (left+right)/2;
                if(cards[mid] == array[i]){
                    found = true;
                    break;
                } else if(cards[mid] > array[i]) {
                    right=mid-1;
                } else {
                    left=mid+1;
                }
            }

            if (found) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }
        bw.flush();
    }
}