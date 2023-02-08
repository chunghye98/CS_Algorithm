package Movie.W3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PrimeN {

    public static boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0 | n <= 1) return false;
        for (int i = n - 2; i > 2; i-=2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;


        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            if (isPrime(n)){
                count++;
            }

        }

        System.out.println(count);




    }

}
