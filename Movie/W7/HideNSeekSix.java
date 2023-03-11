package W7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HideNSeekSix {
    static int GCD(int a, int b){
        int gcd = b;
        if (a % b != 0){
            gcd = GCD(b, a % b);
        }

        return gcd;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int D = Math.abs(S - Integer.parseInt(st.nextToken()));

        for (int i = 1; i < N; i++){
            int temp = Math.abs(S - Integer.parseInt(st.nextToken()));
            D = GCD(D, temp);

        }
        System.out.println(D);


    }

}
