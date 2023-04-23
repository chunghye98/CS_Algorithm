package W12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Good {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        int resultCount = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;

            while (true) {
                if (left == i) left++;
                else if (right == i) right--;
                if (left >= right) break;

                if (arr[left] + arr[right] < arr[i]) {
                    left++;
                } else if (arr[left] + arr[right] > arr[i]) {
                    right--;
                } else {
                    resultCount++;
                    break;
                }

            }

        }
        System.out.println(resultCount);


    }
}
