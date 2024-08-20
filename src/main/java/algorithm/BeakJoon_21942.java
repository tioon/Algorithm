package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BeakJoon_21942 {
    static int fine;
    static long limitTime;
    static Map<String, Long> personFineMap = new TreeMap<>();
    static Map<String, String> personTimeMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));
        String[] inputs = in.readLine().split(" ");
        int T = stoi(inputs[0]);
        limitTime = getTimeLimit(inputs[1]);
        fine = stoi(inputs[2]);

        for (int tc = 0; tc < T; ++tc) {
            inputs = in.readLine().split(" ");
            String currentTime = inputs[0] + " " + inputs[1]; // YYYY-MM-DD hh:mm 구조
            String key = inputs[2] + inputs[3]; // 대여물품과 대여자를 하나로 묶어서 생각한다.
            if (personTimeMap.containsKey(key)) {
                // 빌린 기록이 있다면 대여시간을 충족하는지 확인해보자
                long total = getFine(personTimeMap.get(key), currentTime);
                if (total > 0) // 벌금이 존재한다.
                    personFineMap.put(inputs[3], personFineMap.getOrDefault(inputs[3], 0L) + total);
                personTimeMap.remove(key); // 같은 대여자가 같은 물품을 다시 빌리는 경우가 있다. 기존 값을 지우자.

            } else {
                personTimeMap.put(key, currentTime); // 최초로 빌리는 경우다.
            }
        }

        if (personFineMap.isEmpty()) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (String key : personFineMap.keySet())
                sb.append(key).append(" ").append(personFineMap.get(key)).append("\n");

            System.out.println(sb);
        }
    }

    private static long getFine(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dt1 = LocalDateTime.parse(startTime, formatter);
        LocalDateTime dt2 = LocalDateTime.parse(endTime, formatter);

        Duration duration = Duration.between(dt1, dt2);
        long time = duration.getSeconds() / 60 - limitTime;
        if (time > 0)
            return time * fine;
        return 0;
    }

    private static long getTimeLimit(String s) {
        String[] tl = s.split("/");
        String[] hhmm = tl[1].split(":");
        return stoi(tl[0]) * 24 * 60 + stoi(hhmm[0]) * 60 + stoi(hhmm[1]);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}