package BOJ.n1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소수 구하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] strings = br.readLine().split(" ");
        int M = Integer.parseInt(strings[0]);
        int N = Integer.parseInt(strings[1]);

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) sb.append(i).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

    } // main - end
    public static boolean isPrime(int n) {
        boolean prime = n > 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) prime = false;
        }
        return prime;
    }

} // class - end
