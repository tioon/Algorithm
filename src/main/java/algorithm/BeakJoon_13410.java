package algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BeakJoon_13410 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);

        Integer[] array = new Integer[k];
        for(int i=1; i<=k; i++){
            array[i-1] = n*i;
        }

        for(int i=0; i<k; i++){
            reverse(array, i);
        }

        Arrays.sort(array, Collections.reverseOrder());

        System.out.println(array[0]);
    }



    public static void reverse(Integer[] array, int current){
        String number = Integer.toString(array[current]);

        String newNumber = new StringBuilder(number).reverse().toString();

        array[current] = Integer.parseInt(newNumber);
    }
}