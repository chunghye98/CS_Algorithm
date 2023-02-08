package BOJ.n2609;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        int num1 = Integer.parseInt(strArr[0]);
        int num2 = Integer.parseInt(strArr[1]);


        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);

        // 최대 공약수 = the Greatest Common Divisor
        int GCD = calculateGCD(num1, num2, min);
        // 최소 공배수 = the Least Common Multiple
        int LCM = calculateLCM(num1, num2, max);

        System.out.println(GCD);
        System.out.println(LCM);
    }

    public static int calculateGCD(int a, int b, int min){
        int GCD = 0;
        for (int i = min; i > 0; i--) {
            if ((a % i == 0) && (b % i == 0)) {
                GCD = i;
                break;
            }
        }
        return GCD;
    }

    public static int calculateLCM(int a, int b, int max){
        int LCM = 0;
        while (LCM == 0) {
            if ((max % a == 0) && (max % b == 0)) {
                LCM = max;
            }
            max++;
        }
        return LCM;
    }
}
