package algorithm;

import java.io.*;
import java.util.Arrays;

public class Alice_02 {
    static int n;
    static int m;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫번째 입력 - 배열크기 n, 일한 횟수 k
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        array = new int[n];

        // 두번째 입력 - 배열 초기화
        String[] s2 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(s2[i]);
        }

        // 각 일한 횟수 만큼 반복 i=배열시작점, j=배열끝점, k=배열내 선택지
        for(int a=0; a<m; a++){
            String[] s3 = br.readLine().split(" ");
            int i = Integer.parseInt(s3[0])-1;
            int j = Integer.parseInt(s3[1]);
            int k = Integer.parseInt(s3[2])-1;
            sb.append(select(i,j,k)).append('\n');
        }

        System.out.println(sb); // 출력

    }

    // 배열 정렬 후, 선택지 고름
    public static int select(int i, int j, int k){
        int[] pArray = new int[j-i];

        // 시작점~끝점의 배열 복사
        for(int a=i; a<j; a++){
            pArray[a-i] = array[a];
        }

        Arrays.sort(pArray); // 배열 오름차순 정렬

        return pArray[k]; // 선택지 반환
    }
}
