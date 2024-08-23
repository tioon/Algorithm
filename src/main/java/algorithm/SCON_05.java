package algorithm;

import java.io.*;
import java.util.Stack;

public class SCON_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] words = br.readLine().split(" ");
        boolean result = br.readLine().charAt(0)=='T'?true:false;

        if(words.length==1){
            if(result == (words[0].charAt(0)=='T'?true:false)) {
                System.out.println(0);
                return;
            } else {
                System.out.println(1);
                return;
            }
        }

        Stack<Boolean> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i=words.length-1; i>=0; i--){
            char word = words[i].charAt(0);
            if(word == '|' || word=='&')
                operators.add(word);
            else
                numbers.add(word=='T'?true:false);
        }

        while(operators.size()>0){
            char operator = operators.pop();
            boolean number1 = numbers.pop();
            boolean number2 = numbers.pop();

            boolean value;
            if(operator=='&')
                value = number1 & number2;
            else
                value = number1 || number2;

            if(operators.size() == 0){
                if(value == result){
                    System.out.println(0);
                    return;
                }
                else if((operator=='&' && number1==false && number2==false) || (operator=='|' && number1==true && number2==true)){
                    System.out.println(2);
                    return;
                }
                else{
                    System.out.println(1);
                    return;
                }
            }
            numbers.add(value);
        }



    }
}

// T && T = T
// T && F = F
// F && F = F

// T || T = T
// T || F = T
// F || F = F


//T F F T F
// & | | &

/*
F&F -> T  (2번)
F&T -> T  (1번)
T&T -> F   (1번)
F||F -> T  (1번)
T||T -> F (2번)
F||F -> T (1번)
T&T -> F (1번)*/