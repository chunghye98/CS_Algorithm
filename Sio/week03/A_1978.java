import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 소수 찾기
- 문제: 주어진 수 n개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램
- 해결:
- 주어진 수를 나누어떨어지게 하는 수의 개수가 2와 같으면 count++
- count 출력
 */
public class A_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        while (st.hasMoreTokens()) {
            int size = findFactors(Integer.parseInt(st.nextToken()));
            if (size == 2) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int findFactors(int number) {
        int size = 0;
        for (int i = 1; i <= number; i++) { // 제곱근까지 찾는게 더 반복문 조금 돈다,,지안짱
            if (number % i == 0) {
                size++;
            }
        }
        return size;
    }
}
