package algorithm;

import java.io.*;
import java.util.*;

public class BeakJoon_1106 {
    static class Node {
        int cost;
        int people;

        Node(int cost, int people) {
            this.cost = cost;
            this.people = people;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s1 = br.readLine().split(" ");
        int C = Integer.parseInt(s1[0]); // 필요한 인구 수
        int N = Integer.parseInt(s1[1]); // 도시의 수

        List<Node> cities = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s2 = br.readLine().split(" ");
            int cost = Integer.parseInt(s2[0]);
            int people = Integer.parseInt(s2[1]);
            cities.add(new Node(cost, people));
        }

        int[] dp = new int[C + 101]; // 충분히 큰 배열 생성
        Arrays.fill(dp, Integer.MAX_VALUE); // 초기값을 최대값으로 설정
        dp[0] = 0; // 초기값 설정

        for (int i = 0; i <= C; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                for (Node city : cities) {
                    int next = i + city.people;
                    if (next >= C) next = C; // 필요한 인구 수를 초과할 경우 C로 설정
                    dp[next] = Math.min(dp[next], dp[i] + city.cost);
                }
            }
        }

        System.out.println(dp[C]); // 최소 비용 출력
    }
}