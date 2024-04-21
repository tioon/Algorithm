package algorithm;

import java.io.*;

//백준 1065
public class BeakJoon_11728 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" "); // 두 배열 크기 입력
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] A = new int[N];
        String[] a = br.readLine().split(" "); // A 배열 값 설정
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(a[i]);

        int[] B = new int[M];
        String[] b = br.readLine().split(" "); // B 배열 값 설정
        for(int i=0; i<M; i++)
            B[i] = Integer.parseInt(b[i]);

        int aIndex = 0;
        int bIndex = 0;
        int[] result = new int[N+M]; // 결과 합집합 배열 설정
        int resultIndex=0;

        while(true){
            if(aIndex == A.length){ // 만약 A 배열이 다 선택되고, B가 남은경우. -> 남은 B배열을 결과 배열에 다 넣음
                for(int i =bIndex;i <B.length; i++){
                    result[resultIndex] = B[i];
                    resultIndex++;
                }
                break;
            }
            if(bIndex == B.length){ // 만약 B 배열이 다 선택되고, A가 남은경우. -> 남은 A배열을 결과배열에 다 넣음
                for(int i=aIndex; i<A.length; i++){
                    result[resultIndex] = A[i];
                    resultIndex++;
                }
                break;
            }

            if(A[aIndex] > B[bIndex]){ // 현재 A가 B보다 더 클 경우 -> B를 결과에 넣고 B포인터 증가
                result[resultIndex] = B[bIndex];
                resultIndex++;
                bIndex++;
            }
            else{ // 현재 B가 A보다 더 클 경우 -> A를 결과에 넣고 A포인터 증가
                result[resultIndex] = A[aIndex];
                resultIndex++;
                aIndex++;
            }
        }

        for(int i=0; i<resultIndex; i++){
            bw.write(Integer.toString(result[i])+" ");
        }

        bw.flush();
    }
}