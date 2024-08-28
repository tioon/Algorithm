package algorithm;
import java.io.*;
import java.util.*;

public class BeakJoon_19583 {
    static class Node {
        int hour;
        int minute;

        Node(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        int compareTime(Node o) {
            int hourDiff = this.hour - o.hour;
            if (hourDiff < 0) return -1;  // 이전 시간
            if (hourDiff > 0) return 1;   // 이후 시간

            // hourDiff == 0 인 경우
            int minuteDiff = this.minute - o.minute;
            if (minuteDiff < 0) return -1;  // 이전 시간
            if (minuteDiff > 0) return 1;   // 이후 시간
            return 0;  // 같은 시간
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        Node start = new Node(Integer.parseInt(s1[0].substring(0, 2)), Integer.parseInt(s1[0].substring(3, 5)));
        Node end = new Node(Integer.parseInt(s1[1].substring(0, 2)), Integer.parseInt(s1[1].substring(3, 5)));
        Node streaming = new Node(Integer.parseInt(s1[2].substring(0, 2)), Integer.parseInt(s1[2].substring(3, 5)));

        Set<String> entered = new HashSet<>(); // 시작 시간 이전에 입장한 사람들
        Set<String> confirmed = new HashSet<>(); // 최종적으로 확인된 사람들

        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            String[] s2 = inputLine.split(" ");
            if (s2.length < 2) continue;

            Node current = new Node(Integer.parseInt(s2[0].substring(0, 2)), Integer.parseInt(s2[0].substring(3, 5)));
            String name = s2[1];

            if (current.compareTime(start) <= 0) {
                entered.add(name);
            } else if (current.compareTime(end) >= 0 && current.compareTime(streaming) <= 0) {
                if (entered.contains(name) && !confirmed.contains(name)) {
                    confirmed.add(name);
                }
            }
        }

        System.out.println(confirmed.size());
    }
}
