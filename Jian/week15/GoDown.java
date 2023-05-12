package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.min;

/*
    1. 처음에 N*N 인 줄 알고 2중 for문을 만들었는데, for과 if를 없애고 무비처럼 0, 1, 2로 하면 좋았겠다. (시간)
    2. 그리고 static 되도록 만들지 말자. (메모리)
    = 메모리와 시간이 두배 차이 남.
 */

public class GoDown {
    public static int THREE = 3;
    public static int N;  // 줄 Line
    public static int[][] numList; // 입력 받은 숫자들
    public static int[][] minDP; // 최소 값을 구하기 위한 DP
    public static int[][] maxDP; // 최대 값을 구하기 위한 DP
    public static void main(String[] args) throws IOException {
        input();

        // solution
        if (N == 1){ // 정답 출력 후 종료
            System.out.println(Math.max(numList[0][0], Math.max(numList[0][1], numList[0][2])) + " "
                    + Math.min(numList[0][0], Math.min(numList[0][1], numList[0][2])));
            return;
        }

        maxDP[0] = numList[0];
        minDP[0] = numList[0];
        if (N >= 2) { // DP 계산 시작
            for (int i = 1; i < N; i++){
                for (int j = 0; j < THREE; j++){
                    if (j == 0) { // 선택지가 0, 1 두개이므로
                        maxDP[i][j] = Math.max(maxDP[i-1][j], maxDP[i-1][j+1]) + numList[i][j];
                        minDP[i][j] = Math.min(minDP[i-1][j], minDP[i-1][j+1]) + numList[i][j];
                    }

                    if (j == 1) { // 선택지가 0, 1, 2 세개이므로
                        maxDP[i][j] = Math.max(maxDP[i-1][j-1], Math.max(maxDP[i-1][j], maxDP[i-1][j+1])) + numList[i][j];
                        minDP[i][j] = Math.min(minDP[i-1][j-1], Math.min(minDP[i-1][j], minDP[i-1][j+1])) + numList[i][j];
                    }

                    if (j == 2) { // 선택지가 1, 2 두개이므로
                        maxDP[i][j] = Math.max(maxDP[i-1][j-1], maxDP[i-1][j]) + numList[i][j];
                        minDP[i][j] = Math.min(minDP[i-1][j-1], minDP[i-1][j]) + numList[i][j];
                    }
                }
            }
        }
        
        
        print();
    }
    

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numList = new int[N][THREE];
        for (int i = 0; i < N; i++){
            numList[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        maxDP = new int[N][THREE];
        minDP = new int[N][THREE];
    }

    static void print(){
        int max = Math.max(maxDP[N-1][0], Math.max(maxDP[N-1][1], maxDP[N-1][2]));
        int min = Math.min(minDP[N-1][0], Math.min(minDP[N-1][1], minDP[N-1][2]));
        System.out.println(max + " " + min);
    }
}
