package algorithm;

import java.io.*;
import java.util.*;

public class BeakJoon_14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;

        for(int i=0; i<N; i++){
            String[] s1 = br.readLine().split(" ");
            int cowNum = Integer.parseInt(s1[0]);
            int location = Integer.parseInt(s1[1]);

            if(map.containsKey(cowNum)){
                int oldLocation = map.get(cowNum);

                if(oldLocation != location){
                    count++;
                    map.put(cowNum, location);
                }
            } else{
                map.put(cowNum, location);
            }
        }

        System.out.println(count);
    }
}