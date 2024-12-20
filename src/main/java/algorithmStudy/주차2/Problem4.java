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

        array = new int[w];
        String[] s2 = br.readLine().split(" ");
        for(int i=0; i<w; i++){
            array[i] = Integer.parseInt(s2[i]);
        }

        int answer = 0;
        for(int i=0; i<w; i++){
            int left = checkLeft(i);
            int right = checkRight(i);

            if(array[i] < Math.min(left,right)){
                answer += Math.min(left,right) - array[i];
            }
        }

        System.out.println(answer);


    }

    public static int checkLeft(int current){
        int answer = array[current];

        for(int i=current-1; i>=0; i--){
            answer = Math.max(answer, array[i]);
        }
        return answer;
    }

    public static int checkRight(int current){
        int answer = array[current];

        for(int i=current+1; i<w; i++){
            answer = Math.max(answer, array[i]);
        }
        return answer;
    }
}
