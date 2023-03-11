package Movie.W3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OneTwoThreeFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Integer> inputs = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number > max) max = number;
            inputs.add(number);
        }


        long[] dp = new long[max + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 3;
        long[][] steps = new long[max +1][4];
        steps[0][1] = 1;
        steps[0][2] = 0;
        steps[0][3] = 0;
        steps[1][1] = 0;
        steps[1][2] = 1;
        steps[1][3] = 0;
        steps[2][1] = 1;
        steps[2][2] = 1;
        steps[2][3] = 1;



        for (int i = 3; i <= max; i++) {

            dp[i] = (steps[i - 1][1] % 1000000009) + (steps[i - 1][2]% 1000000009) + (steps[i - 1][3] % 1000000009);

            steps[i][1] = (dp[i] - steps[i - 1][1] % 1000000009); //steps[i - 1][2] + steps[i -1][3] 음수
            steps[i][2] = (dp[i-1] - steps[i - 2][2] % 1000000009);
            steps[i][3] = (dp[i - 2] - steps[i - 3][3] % 1000000009);

        }
        StringBuilder sb = new StringBuilder();
        for (int n : inputs){
            sb.append(dp[n] + "\n");
        }
        System.out.print(sb);


    }


}