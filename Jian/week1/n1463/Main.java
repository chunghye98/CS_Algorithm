package BOJ.n1463;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(recur(N, 0));
    }

    public static int recur(int N, int count){
        if (N < 2) {
            return count;
        }
        return Math.min(recur(N / 2, count + 1 + (N % 2)), recur(N / 3, count + 1 + (N % 3)));
    }
}
