package algorithmStudy.주차2.Problem1;

import java.io.*;

//백준 1212 새풀이
public class Problem1_new {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String octal = br.readLine(); // 8진수 입력받기
        StringBuilder sb = new StringBuilder();

        // 첫 번째 숫자는 앞에 0을 붙이지 않음 -> 맨 앞자리만 예외적으로 변환진행
        sb.append(Integer.toBinaryString(octal.charAt(0) - '0'));

        // 나머지 숫자는 항상 3자리로 변환
        for (int i = 1; i < octal.length(); i++) {
            String binary = Integer.toBinaryString(octal.charAt(i) - '0');
            while (binary.length() < 3) {
                binary = "0" + binary; // 앞에 0을 채움
            }
            sb.append(binary);
        }

        System.out.println(sb);
    }
}

