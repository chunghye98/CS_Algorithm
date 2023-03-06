package Movie.W6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SumGCD {
    static long GCD(int a, int b){
        long gcd = b;
        if (a % b != 0){
            gcd = GCD(b, a % b);
        }

        return gcd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            st.nextToken();
            while(st.hasMoreTokens()){
                list.add(Integer.parseInt(st.nextToken()));
            }
            long sum = 0;
            for (int j = 0; j < list.size(); j ++){
                for (int k = j + 1; k < list.size(); k ++){
                    int a = list.get(j);
                    int b = list.get(k);
                    sum += GCD(a,b);
                }
            }
            sb.append(sum + "\n");

        }

        System.out.print(sb);
    }
}
