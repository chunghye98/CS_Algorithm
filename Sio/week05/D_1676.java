/* 팩토리얼 0의 개수
- 문제: n! 뒤에서부터 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오
- 0이 생기는 경우
    - 10이 곱해질 때
    - 2 * 5
    - 2의 배수보다 5의 배수의 수가 더 적음 -> 5의 배수의 갯수만 세기
    - n의 범위는 500까지이므로 5, 25, 125의 경우만 고려해면 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int count = 0;
        for (int i = n; i > 0; i--) {
            if (i % 5 == 0) count++;
            if (i % 25 == 0) count++;
            if (i % 125 == 0) count++;
        }
        System.out.println(count);
    }
}
