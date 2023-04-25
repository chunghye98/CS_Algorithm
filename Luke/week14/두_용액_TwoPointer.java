import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이것도 시간 초과라고?????????
 */

public class 두_용액_TwoPointer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        int left = 0;
        int right = N - 1;
        int resultOfL = left;
        int resultOfR = right;
        int min = solutions[left] + solutions[right];

        while (left < right) {

            if (solutions[left] + solutions[right] > 0) {
                right--;
            }

            if (solutions[left] + solutions[right] < 0) {
                left++;
            }

            if (Math.abs(min) > Math.abs(solutions[left] + solutions[right])) {
                min = solutions[left] + solutions[right];
                resultOfR = right;
                resultOfL = left;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(solutions[resultOfL] + " " + solutions[resultOfR]);
        System.out.println(sb);
    }
}
