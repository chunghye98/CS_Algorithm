package BOJ.n1978;

import java.io.*;
import java.util.StringTokenizer;

// 소수 찾기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // StringTokenizer 사용해서 필요없음.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if (isPrime(number)) count++;
        } // while - end
        System.out.println(count);
    } // main - end

    public static boolean isPrime(int number) {
        boolean result = (number != 1); // 오 이거 신기함. 컴파일러가 clean up 해줌.
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
} // class - end
