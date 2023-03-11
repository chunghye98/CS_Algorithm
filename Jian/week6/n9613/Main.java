package BOJ.week6.n9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

// 9613 GCD 합 - resultCount를 long으로.
/*
 입력받은 수가 1,000,000 언저리의 숫자이며 100개를 입력 받았을 때, int 범위를 벗어나므로 long형으로 받아야했음.2,147,483,647
 참고 블로그 https://wonit.tistory.com/414
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int[] array = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] array2 = Arrays.copyOfRange(array, 1, array.length);
            int indexN = array[0];// 1, 2, 3, 4, 5
            Arrays.sort(array2); // 오름차 순으로 정렬 -> 시간이 오래 걸릴 것 같아서
            long resultCount = 0;

            for (int i = indexN-1; i >= 1; i--) { // 뒤부터 확인
                for (int j = i-1; j >= 0; j--) {
                    resultCount += recurGCD(array2[i], array2[j]);
                }
            } // for - end
            sb.append(resultCount).append("\n");
        } // while - end
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);
    } // main - end

    // 유클리드 호제법 사용한 재귀. 내림차순으로 정렬이 되어있어야 함.
    public static int recurGCD(int biggerInt, int smallerInt){
           if (biggerInt % smallerInt == 0) {
               return smallerInt;
           }

           return recurGCD(smallerInt, biggerInt % smallerInt);
    } // recurGCD - end
}
