package algorithm;

import java.io.*;

public class BeakJoon_21921 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int X = Integer.parseInt(s[1]);

        int[] array = new int[N];
        String[] a = br.readLine().split(" ");
        for(int i=0; i<N; i++)
            array[i] = Integer.parseInt(a[i]);

        int startIndex = 0; // Index 값 설정
        int endIndex = X;
        int max = 0;
        int maxCount=0;

        int sum=0; // 초기 방문기록합 계산
        for(int i=startIndex; i<endIndex; i++)
            sum += array[i];

        max = sum; // 초기 max값은 첫날~X일까지
        maxCount = 1;

        while(endIndex < array.length){ // endIndex가 끝날때까지 반복
            sum-=array[startIndex++]; // 하나식 증가하면서 빼기
            sum+=array[endIndex++]; // 하나씩 증가하면서 더하기

            if(max < sum){ // 만약 더큰 값이 나오면 max 및 count 초기화
                max = sum;
                maxCount=1;
            }
            else if(max == sum) // 만약 같은 값이 나오면 maxCount 증가
                maxCount++;
        }

        if(max==0) // 아무것도 안나오면 SAD
            bw.write("SAD");
        else
            bw.write(max+ "\n" + maxCount);

        bw.flush();
    }
}