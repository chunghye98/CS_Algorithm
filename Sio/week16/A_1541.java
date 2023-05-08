import java.io.*;
import java.util.*;

/* 1541, 잃어버린 괄호
- 시간 제한: 2초
- 그리디 문제

< 접근 방법 >
1. + 연산을 먼저 해주고 - 연산을 하면 항상 값이 최소로 나온다.
2. - 로 문자열 파싱
3. 파싱한 요소가 정수 변환 가능하면 리스트에 넣어준다.
4. 파싱한 요소가 정수 변환 불가능하면 +로 요소를 또다시 파싱해준다.
5. +로 파싱한 요소들을 모두 더해서 리스트에 넣어준다.
6. 리스트의 첫번째 요소에서 나머지 요소들을 전부 뺀다.
 */
public class A_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        List<Integer> minusList = new ArrayList<>();

        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            try {
                int minus = Integer.parseInt(temp);
                minusList.add(minus);
            } catch (NumberFormatException e) {
                StringTokenizer st2 = new StringTokenizer(temp, "+");
                int n = 0;
                while (st2.hasMoreTokens()) {
                    n += Integer.parseInt(st2.nextToken());
                }
                minusList.add(n);
            }
        }

        int sum = minusList.get(0);
        for (int i = 1; i < minusList.size(); i++) {
            sum -= minusList.get(i);
        }
        System.out.println(sum);
    }
}
