package BOJ.week5.n1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1676 팩토리얼 0의 개수
// 첫번째 시도 : 숫자를 다 곱한 다음(팩토리얼) 10으로 나눈 나머지가 0인지 확인 한 후에 count 하는 방식
// 두번째 시도 : 숫자를 다 곱한 다음(팩토리얼) 문자열로 만들고, split('')해서 문자열의 뒷쪽부터 세는 방식.
// 세번째 : 구글 검색. 1~n이 2와 5로 나누어 떨어지는지 확인 하고, 각각 count 해서 Math.min으로 더 작은 count를 출력하는 방식.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int two_count = 0;
        int five_count = 0;

        for (int i = 1; i <= n; i++) {
            int temp = i;

            while (temp % 2 == 0){
                two_count++;
                temp /= 2;
            }
            while (temp % 5 == 0){
                five_count++;
                temp /= 5;
            }
        }
        int result = Math.min(two_count, five_count);
        System.out.println(result);
    }
        /* 맨 처음 시도 - 시간 초과
        while ((factorial % 10) == 0) {
            count++;
            factorial /= 10;
        }

         */

        /* 두번째 시도 - 틀렸습니다.
        String[] array = Integer.toString(factorial).split("");
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i].equals("0")) count++;
        }
        System.out.println(count);
         */
 /*
    public static int recur(int n) {
        if (n <= 1) return 1;
        return recur(n-1) * n;
    }
 */
}
