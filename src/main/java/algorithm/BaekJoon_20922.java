package algorithm;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int K = Integer.parseInt(a[1]);
        int[] array = new int[N];
        int result =0;

        String[] s = br.readLine().split(" ");
        for(int i=0; i<N; i++)
            array[i] = Integer.parseInt(s[i]);

        int[] count = new int[1000001];
        int start=0;
        int end=0;


        while(end < N){
            count[array[end]]++;
            if(count[array[end]] > K){
                while(count[array[end]] > K){
                    count[array[start]]--;
                    start++;
                }
            }
            result = Math.max(result,end-start+1);
            end++;
        }

        System.out.println(result);
    }
}