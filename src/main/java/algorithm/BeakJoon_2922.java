package algorithm;
import java.io.*;

public class BeakJoon_2922 {
    static char[] words;
    static long result = 0;
    static char[] vowel = {'A', 'E', 'I', 'O', 'U'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        words = s.toCharArray();  // 바로 toCharArray로 변환

        dfs(0, 1, false, 0, 0);

        System.out.println(result);
    }

    // DFS 함수에 추가로 L 포함 여부, 연속된 자음 및 모음 개수를 인자로 전달
    public static void dfs(int index, int sum, boolean hasL, int consonantCount, int vowelCount) {
        // 연속된 자음 또는 모음이 3개 이상인 경우 탐색 종료
        if (consonantCount >= 3 || vowelCount >= 3) return;

        if (index == words.length) {
            // 'L'이 포함된 경우에만 결과 추가
            if (hasL) result += sum;
            return;
        }

        char word = words[index];

        if (word == '_') {
            // 모음으로 대체
            words[index] = 'A';
            dfs(index + 1, sum * 5, hasL, 0, vowelCount + 1);
            // 'L'을 자음으로 대체
            words[index] = 'L';
            dfs(index + 1, sum * 1, true, consonantCount + 1, 0);

            // 'L'이 아닌 다른 자음으로 대체
            words[index] = 'D';  // 예시로 'D' 사용, 다른 자음들도 동일하게 처리
            dfs(index + 1, sum * 20, hasL, consonantCount + 1, 0);

            // 복원
            words[index] = '_';
        } else {
            if (isVowel(word)) {
                dfs(index + 1, sum, hasL, 0, vowelCount + 1);
            } else {
                dfs(index + 1, sum, hasL || word == 'L', consonantCount + 1, 0);
            }
        }
    }

    // 자음, 모음 체크 함수 간소화
    public static boolean isVowel(char c) {
        for (char v : vowel) {
            if (c == v) return true;
        }
        return false;
    }
}
