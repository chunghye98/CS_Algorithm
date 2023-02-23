package BOJ.n1934;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int recursiveNumber = Integer.parseInt(br.readLine());

        while (recursiveNumber-- > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            // 시간초과 나서 유클리드 호제법 사용.
            // 두 수의 곱을 최대공약수로 나누면 최소공배수의 값이 나온다.
            int GCD = (a * b) / LCM(a, b);
            bw.write(GCD + "\n");
        }
        bw.flush();
    }

    static public int LCM(int a, int b) {
        while (b > 0) {
            int rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }
}
