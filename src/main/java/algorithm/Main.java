package algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        int r = Integer.parseInt(s1[0]); // 세로
        int c = Integer.parseInt(s1[1]); // 가로

        char[][] array = new char [r+1][c+1];
        for(int i=1; i<r+1; i++){
            String s2 = br.readLine();

            for(int j=1; j<c+1; j++){
                array[i][j] = (s2.charAt(j-1));
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for(int i=1; i<r+1; i++){
            for(int j=1; j<c+1; j++){
                char current = array[i][j];

                if(current == '#')
                    continue;
                else{
                    //가로 탐지
                    if(array[i][j-1]==0 || array[i][j-1]=='#'){
                        StringBuilder sb = new StringBuilder();
                        sb.append(array[i][j]);

                        int j_p = j;
                        while(j_p+1<c+1 && array[i][j_p+1]!='#'){
                            sb.append(array[i][j_p+1]);
                            j_p++;
                        }
                        //System.out.println(sb.toString());
                        if(sb.length()>=2)
                            list.add(sb.toString());
                    }

                    if(array[i-1][j]==0 || array[i-1][j]=='#'){
                        StringBuilder sb = new StringBuilder();
                        sb.append(array[i][j]);

                        int i_p =i;
                        while(i_p+1<r+1 && array[i_p+1][j]!='#'){
                            sb.append(array[i_p+1][j]);
                            i_p++;
                        }
                        //System.out.println(sb.toString());
                        if(sb.length()>=2)
                            list.add(sb.toString());
                    }
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));

    }
}