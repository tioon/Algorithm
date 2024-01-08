package algorithm;

import java.io.*;
import java.util.*;

//백준 1065
public class BeakJoon_28114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] solvedProblem = new int [3];
        int[] years = new int [3];
        String[] Name = new String[3];

        for(int i=0; i<3; i++){
            String[] s = br.readLine().split(" ");
            solvedProblem[i] = Integer.parseInt(s[0]);
            years[i] = Integer.parseInt(s[1]);
            Name[i] = s[2];
        }

        Arrays.sort(years);
        for(int i=0; i<3; i++){
            for(int j=i; j<3; j++){
                if(solvedProblem[i] < solvedProblem[j]){
                    int temp1 = solvedProblem[i];
                    solvedProblem[i] = solvedProblem[j];
                    solvedProblem[j] = temp1;

                    String temp2 = Name[i];
                    Name[i] = Name[j];
                    Name[j] = temp2;
                }
            }
        }

        for(int i=0; i<3; i++)
            bw.write(Integer.toString(years[i]-2000));
        bw.write('\n');
        for(int i=0; i<3; i++)
            bw.write(Name[i].charAt(0));

        bw.flush();
    }
}