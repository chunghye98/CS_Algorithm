import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 팩토리얼
- 0보다 크거나 같은 정수 n이 주어진다. 이때 n!을 출력하는 프로그램을 작성하시오
- for문 써서 n에서 -1씩 곱한 것을 출력한다.
 */
public class C_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        System.out.println(result);
    }
}
