import java.io.*;
import java.util.*;

/* 1339, 단어 수학
- 시간 제한: 2초
- 그리디 문제
- 많이 고민하다가 인터넷 검색함 : https://1-7171771.tistory.com/112
< 접근 방법 >
1. 문제는 max 값을 찾는 것이므로 높은 자릿수에 높은 값을 부여해야 한다.
2. 자릿수를 먼저 계산하고 26자리의 int형 배열에서 해당 알파벳에 맞는 인덱스에 자릿수를 넣는다.
3. 26자리의 int형 배열을 정렬하고, 값이 0이 나올 때까지 높은 값에 자릿수를 곱한 값을 누적한다.
 */
public class C_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int[] alpha = new int[26]; // 알파벳 개수
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            int temp = (int) Math.pow(10, arr[i].length() - 1);
            for (int j = 0; j < arr[i].length(); j++) {
                alpha[(int) arr[i].charAt(j)-65] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(alpha);
        int index = 9;
        int sum = 0;
        for (int i = alpha.length - 1; i >= 0; i--) {
            if (alpha[i] == 0) {
                break;
            }
            sum += alpha[i] * index;
            index--;
        }
        System.out.println(sum);
    }
}
