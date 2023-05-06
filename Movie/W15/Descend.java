package W15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Descend {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dpMin = new int[100001][3];
        int[][] dpMax = new int[100001][3];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        dpMin[1][0] = Integer.parseInt(st.nextToken());
        dpMin[1][1] = Integer.parseInt(st.nextToken());
        dpMin[1][2] = Integer.parseInt(st.nextToken());

        dpMax[1][0] = dpMin[1][0];
        dpMax[1][1] = dpMin[1][1];
        dpMax[1][2] = dpMin[1][2];

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dpMin[i][0] = a + Math.min(dpMin[i - 1][0], dpMin[i - 1][1]);
            dpMin[i][1] = b + Math.min(dpMin[i - 1][0], Math.min(dpMin[i - 1][1], dpMin[i - 1][2]));
            dpMin[i][2] = c + Math.min(dpMin[i - 1][1], dpMin[i - 1][2]);

            dpMax[i][0] = a + Math.max(dpMax[i - 1][0], dpMax[i - 1][1]);
            dpMax[i][1] = b + Math.max(dpMax[i - 1][0], Math.max(dpMax[i - 1][1], dpMax[i - 1][2]));
            dpMax[i][2] = c + Math.max(dpMax[i - 1][1], dpMax[i - 1][2]);

        }


        System.out.println(Math.max(Math.max(dpMax[N][0], dpMax[N][1]), dpMax[N][2]) + " " +
                 Math.min(Math.min(dpMin[N][0], dpMin[N][1]), dpMin[N][2]));


    }
}
