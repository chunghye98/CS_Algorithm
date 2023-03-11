package BOJ.week6.n2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

// 조합 0의 개수 - failed (시간 초과)
/*
 1. 순열 및 조합이 팩토리얼을 이용한 식이라는 것을 알았다.
 2. 1676번 팩토리얼 0의 개수 때 찾았던 블로그를 다시 참고 https://st-lab.tistory.com/165
 3. 순열을 구하는 경우는 twoCount, fiveCount를 해주고 Math.min(twoCount, fiveCount)로 zeroCount를 구한다.
 4. r! 로 다시 나누어 주어야 하니까 5의 배수만 카운트 해준 만큼 zeroCount에서 빼준다.

 ✅내가 짠 코드가 좀 복잡해 보여서 다른 분들 코드를 잘 봐야겠다!
 */
public class MainTimeOut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array[0];
        int m = array[1];

        int twoCount = 0;
        int fiveCount = 0;
        int zeroCount = 0;

        int recurse = n - m;
        while (n-- > recurse) { // 반복 횟수
            int tempN = n+1;

            fiveCount += countNumber(tempN, 5);
            twoCount += countNumber(tempN, 2);
        }
        zeroCount = Math.min(twoCount, fiveCount);

        // m!을 구하는 방법 1 (완벽한 팩토리얼을 구할 때만 사용 가능할 듯 하다.)
        while (m-- > 0) {
            int tempM = m + 1;
            zeroCount -= countNumber(tempM, 5);
        }
        System.out.println(zeroCount);
    }

    public static int countNumber(int n, int divNumber){ // 5 ,2
        int count = 0;
        while (n % divNumber == 0) {
            count++;
            n /= divNumber;
        }
        return count;
    }
        
//        // m!을 구하는 방법 2
//        while (m-- > 0) { // 반복 횟수
//            int tempM = m+1;
//
//            while (tempM % 5 == 0) {
//                zeroCount--;
//                tempM /= 5;
//            }
//        }

}
