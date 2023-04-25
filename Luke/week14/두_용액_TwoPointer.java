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
        int resultOfL = solutions[left];
        int resultOfR = solutions[right];
        int min = Math.abs(solutions[left] + solutions[right]);
        int sum;
        int temp;

        while (left < right) {

            sum = solutions[left] + solutions[right];
            temp = Math.abs(sum);

            if (min > temp) {
                min = temp;
                resultOfR = solutions[right];
                resultOfL = solutions[left];
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(resultOfL + " " + resultOfR);
    }
}
