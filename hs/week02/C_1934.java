import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최소공배수
public class C_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            System.out.println(solve(a, b));
        }
    }

    private static int solve(int a, int b) {
        int min = Math.min(a, b);
        int maxFactor = -1;
        for (int i = min; i >= 0; i--) {
            if ((a % i == 0) && (b % i == 0)) {
                maxFactor = i;
                break;
            }
        }
        int result = maxFactor * (a / maxFactor) * (b / maxFactor);
        return result;
    }
}
