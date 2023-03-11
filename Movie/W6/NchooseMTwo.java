package Movie.W6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NchooseMTwo {
    static int getZero(long n, int a) {
        int count = 0;
        while (n>=a) {
            count += n / a;
            n /= a;
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        int nTwo = getZero(n, 2);
        int mTwo = getZero(m, 2);
        int nmTwo = getZero(n - m, 2);


        int nFive = getZero(n, 5);
        int mFive = getZero(m, 5);
        int nmFive = getZero(n - m, 5);


        int countTwo = nTwo - mTwo - nmTwo;
        int countFive = nFive - mFive - nmFive;

        int result = Math.min(countTwo, countFive);

        if (m == 0){
            System.out.println(0);
        } else if (n == m){
            System.out.println(0);
        } else {
            System.out.println(result);
        }



    }


}
