package W8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Stairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[N + 1];
        dp[1] = list.get(1);
        if(N>1){
            dp[2] = list.get(2) + list.get(1);


            for (int i = 3; i <= N; i++) {
                dp[i] = Math.max(list.get(i - 1) + dp[i - 3], dp[i - 2]) + list.get(i);

            }
        }

        System.out.println(dp[N]);


    }

}
