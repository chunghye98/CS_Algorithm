package BOJ.week6.n2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

// 조합 0의 개수 - 성공
/* 변경 방식
 이전)
     - divisor의 개수만큼 계속 반복
     - n % divisor == 0 인지 확인해서, divisor(= 2, 5)로 나눠지면 n /= divisor 반복
 지금)
     - n / divisor 의 몫을 바로 count에 더해서 시간 절약.
     - n이 divisor 보다 클 때만 공식 적용 가능. (조건문으로 확인)

 참고 블로그 https://st-lab.tistory.com/165
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array[0];
        int m = array[1];

        // 조합 공식 = n! / (n - m)! / m!
        int twoCount = countDivisorNumber(n, 2) - countDivisorNumber(n-m, 2) - countDivisorNumber(m, 2);
        int fiveCount = countDivisorNumber(n, 5) - countDivisorNumber(n-m, 5) - countDivisorNumber(m, 5);
        int zeroCount = Math.min(twoCount, fiveCount);
        System.out.println(zeroCount);
    }

    // 0만 카운트 한다.
    public static int countDivisorNumber(int n, int divisor){
        int count = 0;
        while (n >= divisor) {
            count += n / divisor;
            n /= divisor;
        }

        return count;
    }

}
