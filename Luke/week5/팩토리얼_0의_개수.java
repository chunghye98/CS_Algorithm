import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 조건
 * 0 <= N <= 500
 * -> int든 long이든 정상적인 범위의 수로 나오지 않는다.
 * -> 실제로 곱하는 것이 아니다
 *
 * 끝 자리에 0이 추가되는 경우:
 * 1. 5의 배수 하나당 0 한자리 추가
 * 2. 5의 제곱의 배수 하나당 0 한자리 추가
 * 3. 5의 세제곱의 배수 하나당 0 한자리 추가
 * N <= 500 이므로 세제곱까지만 하면 된다.
 *
 * !! N의 범위가 주어지지 않는다면 어떻게 일반화를 시킬까?
 */

public class 팩토리얼_0의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = N / 5 + N / 25 + N / 125;
        System.out.println(count);
    }
}
