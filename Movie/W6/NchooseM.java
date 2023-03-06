package Movie.W6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NchooseM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //(n choose m) = n! / (m! * (n-m)!)
        int a = getZero(n);
        int b = getZero(m);
        int c = getZero(n - m);

        int fa = getLastTwoDigit(n);
        int fb = getLastDigit(m);
        int fc = getLastDigit(n - m);
        int fbfc = fb * fc;
        if (fa % fbfc == 0) {
            if (fc * fb == 10) {

                System.out.println(a - b - c - 1);

            }else{
                System.out.println(a - b - c);
            }

        } else {
            System.out.println(0);
        }



    }

    private static int getLastTwoDigit(int n) {
        n %= 100;
        int fact = 1;
        int divider = 100;

        for (int i = 1; i <= n; i++) {
            if (i == n) {
                int count = 0;
                while (fact % 10 == 0) {
                        fact/=10;
                }
                fact = fact % 100;
                break;
            }
            fact *= i;
            if (fact > divider) {
                if (fact % divider != 0) {
                    fact = fact % divider;
                } else {
                    fact = fact / divider;
                }

            }
        }

        return fact;

    }

    static int getZero(int n) {
        int count = 0;
        int five = 5;
        while (five <= n) {
            count += n / five;
            five *= 5;
        }
        return count;
    }

    //1165161 15612
    static int getLastDigit(int n) {
        n %= 100;
        int fact = 1;
        int divider = 10;

        for (int i = 1; i <= n; i++) {
            fact *= i;
            if (fact > divider) {
                if (fact % divider != 0) {
                    fact = fact % divider;
                } else {
                    fact = fact / divider;
                }

            }
        }
        if (fact % divider != 0) {
            fact = fact % divider;
        } else {
            fact = fact / divider;
        }
        return fact;
    }


}
