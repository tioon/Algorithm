package algorithmStudy.주차2;

import java.io.*;

//백준 1212
public class Problem4 {
    static int h; // 높이
    static int w; // 너비
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s1 = br.readLine().split(" ");
        h = Integer.parseInt(s1[0]);
        w = Integer.parseInt(s1[1]);

        // 빗물 크기 입력
        array = new int[w];
        String[] s2 = br.readLine().split(" ");
        for(int i=0; i<w; i++){
            array[i] = Integer.parseInt(s2[i]);
        }

        int answer = 0;
        // 전체 가로크기만큼 진행
        for(int i=0; i<w; i++){
            int left = checkLeft(i); // 왼쪽 최댓값 계산
            int right = checkRight(i); // 오른쪽 최댓값 계싼

            // 만약 현재 값보다 왼쪽 및 오른쪽 값이 더 크다면, 빗물이 고일 수 있으므로 빗물값 업데이트
            if(array[i] < Math.min(left,right)){
                answer += Math.min(left,right) - array[i];
            }
        }

        System.out.println(answer);


    }

    //왼쪽 최댓값 체크하는 함수
    public static int checkLeft(int current){
        int answer = array[current];

        for(int i=current-1; i>=0; i--){
            answer = Math.max(answer, array[i]);
        }
        return answer;
    }

    //오른쪽 체크하는 함수
    public static int checkRight(int current){
        int answer = array[current];

        for(int i=current+1; i<w; i++){
            answer = Math.max(answer, array[i]);
        }
        return answer;
    }
}
