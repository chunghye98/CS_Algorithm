package Movie.W5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GoldBachTwo {

    private static boolean[] PrimeList(int n) {
        boolean[] check = new boolean[n + 1];


        int max = (int) Math.pow(n, 0.5);
        for (int i = 2; i <= max; i++) {
            if (!check[i]) {
                for (int j = i + i; j < n; j += i) {
                    check[j] = true;
                }
            }

        }
        check[0] = true;
        check[1] = true;
        check[2] = true;
        return check;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> Pairs = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        while (n != 0) {
            if (n > max) {
                max = n;
            }
            Pairs.add(n);
            n = Integer.parseInt(br.readLine());
        }

        boolean[] PrimeList = PrimeList(max);

        StringBuilder result = new StringBuilder();

        for (Integer N : Pairs) {
            boolean RightOrWrong = false;
            int a = 0;
            int b = 0;

            for (int i = 1; i <= N / 2; i += 2) {
                if (!PrimeList[i] && !PrimeList[N - i] && ((i + (N - i)) == N)) {
                    a = i;
                    b = N - i;
                    RightOrWrong = true;
                    result.append(N + " = " + a + " + " + b + "\n");
                    break;
                }
//                if (i + (N - i) > N) {
//                    break;
//                }

//                if (RightOrWrong) {
//                    break;
//                }
            }
            if (RightOrWrong == false) {
                result.append("Goldbach's conjecture is wrong.\n");
            }

        }
        System.out.println(result);


    }

}
