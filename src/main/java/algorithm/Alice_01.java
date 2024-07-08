package algorithm;

import java.io.*;
import java.util.*;

public class Alice_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split("");
        int size = s1.length;
        int[] N = new int[size];
        for(int i=0; i<size; i++){
            N[i] = Integer.parseInt(s1[i]);
        }

        int target=0;

        // 오른쪽 시작, 순열이 감소하는 처음 부분 찾음
        // 감소하는 부분 -> target이 됨.
        for(int i=size-1; i>0; i--){
            if(N[i] > N[i-1]){
                target = i-1;
                break;
            }
        }

        int min = Integer.MAX_VALUE;
        int index = target;

        // target 오른쪽에서 target보다 큰 것중에 가장 작은 값을 선택
        for(int i=target+1; i<size; i++){
            if(N[target] < N[i] && min > N[i]) {
                min = N[i];
                index = i;
            }
        }

        // target과 index값을 교환
        int temp = N[target];
        N[target] = N[index];
        N[index] = temp;

        // target 오른쪽값들을 오름차순으로 정렬
        Arrays.sort(N,target+1,size);

        for(int i=0; i<size; i++)
            bw.write(Integer.toString(N[i]));

        bw.flush();
    }
}