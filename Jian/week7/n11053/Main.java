package week7.n11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 가장 큰 증가하는 수열
public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] inputArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] dp = new int[n];
//        dp[0] = 1;
//        int max = inputArray[0];
//
//        for (int i = 1; i <= n; i++) {
//            dp[i] = dp[i-1];
//            if (inputArray[i] > max) {
//                max = inputArray[i];
//                dp[i] = dp[i-1] + 1;
//            }
//        }
//
//        System.out.println(dp[n]);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> set = new HashSet<>();

        for (int number : intArr) {
            set.add(number);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (list.get(i) > list.get(j)) {
                    count++;
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);
    }
}
