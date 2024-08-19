package algorithm;

import java.io.*;
import java.util.*;

public class BeakJoon_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String,Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        int size=0;

        String tree;
        while ((tree = br.readLine()) != null) {
            if (tree.isEmpty()) break; // 빈 줄이 들어오면 종료

            size++;

            if(map.containsKey(tree)){
                int value = map.get(tree);
                map.put(tree,value+1);
            } else {
                map.put(tree,1);
                list.add(tree);
            }
        }

        Collections.sort(list);

        for(int i=0; i< list.size(); i++){
            String current = list.get(i);
            int count = map.get(current);

            String result = String.format("%.4f", ((double)count/size)*100);
            bw.write(current+" "+result+'\n');
        }
        bw.flush();
    }
}