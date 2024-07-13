package algorithm;

import java.io.*;
import java.util.*;

public class BeakJoon_1174 {
    static ArrayList<Long> list = new ArrayList<>();
    static int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1자리부터 10자리까지 가능한 감소하는 숫자 생성
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < 10; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(j);
                dfs(i - 1, j, sb);
            }
        }

        Collections.sort(list);

        if (n > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(n - 1));
        }
    }

    public static void dfs(int size, int end, StringBuilder sb) {
        if (size == 0) {
            list.add(Long.parseLong(sb.toString()));
            return;
        }

        for (int i = 0; i < end; i++) {
            sb.append(i);
            dfs(size - 1, i, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}



// 0 1 2 3 4 5 6 7 8 9    10    20 21     30 31 32     40 41 42 43  ~~~ 90 98    ~~~      210    310 320 321