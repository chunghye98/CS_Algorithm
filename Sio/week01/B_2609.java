package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대공약수와 최대공배수
public class B_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int divisor = findDivisor(a, b);
        int multiple = findMultiple(divisor, a, b);

        System.out.println(divisor);
        System.out.println(multiple);
    }

    // 최소공배수 찾기
    private static int findMultiple(int divisor, int a, int b) {
        return (a / divisor) * (b / divisor) * divisor;
    }

    // 최대공약수 찾기
    private static int findDivisor(int a, int b) {
        int min = Math.min(a, b);
        int index = 2;
        int commonDivisor = 1;
        while (index <= min) {
            if ((a % index == 0) && (b % index == 0)) {
                commonDivisor *= index;
                a = a / index;
                b = b / index;
            } else {
                index++;
            }
        }
        return commonDivisor;
    }
}
