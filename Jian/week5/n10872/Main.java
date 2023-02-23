package BOJ.week5.n10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10872 팩토리얼
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(recur(n));
    }

    public static int recur(int n) {
        if (n <= 1) return 1;
        return recur(n-1) * n;
    }
}
