package algorithm;

import java.io.*;

//백준 1027
public class BeakJoon_1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int leftCount=0;
        int rightCount=0;
        int max=0;
        int N = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        int[] array = new int[s.length];

        for(int i=0; i<N; i++)
            array[i] = Integer.parseInt(s[i]);


        // 매 타워마다 반복
        for(int i=0; i<N; i++){
            leftCount = left(array, i); // 본인기준 왼쪽 타워 탐색
            rightCount = right(array, i); // 본인기준 오른쪽 타워 탐색
            int sum = leftCount + rightCount; // 볼 수 있는 타워 개수 계산
            if (max<sum)
                max = sum;
        }

        bw.write(Integer.toString(max));
        bw.flush();

    }

    //왼쪽 타워 탐색
    public static int left(int[] array, int start){
        double minInclination = Integer.MAX_VALUE; // 기울기 최솟값
        int count=0;

        if(start == 0)
            return 0;
            // 왼쪽 타워가 없으면 0 리턴
        else{
            // 본인 타워 기준 왼쪽 타워 탐색
            for(int i=start-1; i>=0; i--){
                double inclination = (double) (array[i]-array[start]) / (i-start); // 기울기 계산
                // 만약 현재 타워와 해당 타워의 기울기가 기울기 최소값보다 작다면 타워가 보이는 것임.
                if(minInclination > inclination) {
                    minInclination = inclination; // 기울기 최솟값 > 기울기이면 볼 수 있음
                    count++;
                }
            }
        }

        return count;
    }

    //오른쪽 타워 탐색
    public static int right(int[] array, int start){
        double maxInclination = Integer.MIN_VALUE; // 기울기 최댓값
        int count=0;

        if(start == array.length-1)
            return 0;
            // 오른쪽 타워가 없으면 0 리턴
        else{
            // 본인 타워 기준 오른쪽 타워 탐색
            for(int i=start+1; i<array.length; i++){
                double inclination = (double) (array[start]-array[i]) / (start-i); // 기울기 계산
                // 만약 현재 타워와 해당 타워의 기울기가 기울기 최대값보다 크다면 타워가 보이는 것임.
                if(maxInclination < inclination) {
                    maxInclination = inclination; // 기울기 최댓값 < 기울기이면 볼 수 있음.
                    count++;
                }
            }
        }

        return count;
    }
}