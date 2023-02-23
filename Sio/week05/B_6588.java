import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 골드바흐의 추측
- index = 1000000 에서 0까지 -1하면서 while문
- 짝수 정수 n 입력 (입력이 0 이면 프로그램 종료)
- 에라토스테네스의 체로 n보다 작은 소수 배열 찾기
- 조합으로 홀수 소수 두 개 찾기
    - 여러 개면 b-a가 가장 큰 것
    - 없으면 Goldbach's conjecture is wrong. 출력
- 찾은 소수 두 개와 짝수 n 출력
 */
public class B_6588 {

    public static void main(String[] args) throws IOException {
        B_6588 main = new B_6588();
        int index = 100000;
        while (index > 0) {
            int input = main.input();
            if(input == 0) break;
            List<Integer> primes = main.findPrimes(input);
            List<int[]> combinations = main.findCombinations(primes, input);
            if(combinations.size() == 0) System.out.println("Goldbach's conjecture is wrong.");
            int[] result = main.findResult(combinations);
            main.printResult(result, input);
            index--;
        }
    }

    private BufferedReader br;
    private StringBuilder sb;

    public B_6588() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.sb = new StringBuilder();
    }

    private int input() throws IOException {
        int input = Integer.parseInt(br.readLine());
        // 입력이 짝수가 아니면 Exception으로 던짐
        if (input % 2 != 0) {
            throw new IOException();
        }
        return input;
    }


    private List<Integer> findPrimes(int input) {
        boolean[] checkedPrimes = new boolean[input + 1];
        checkedPrimes[0] = checkedPrimes[1] = true; // 소수가 아니면 true

        for (int i = 2; i * i <= input; i++) {
            if (!checkedPrimes[i]) {
                for (int j = i * i; j <= input; j += i) {
                    checkedPrimes[j] = true;
                }
            }
        }

        //소수(false) 배열 리턴
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < checkedPrimes.length; i++) {
            if (!checkedPrimes[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    // 합해서 짝수 n을 만들 수 있는 두 홀수 조합 찾기
    private List<int[]> findCombinations(List<Integer> primes, int input) {
        List<int[]> combinations = new ArrayList<>();
        for (int i = 0; i < primes.size() - 1; i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (input == primes.get(i) + primes.get(j)) {
                    combinations.add(new int[]{primes.get(i), primes.get(j)});
                }
            }
        }
        return combinations;
    }


    // b-a 가 최대인 조합 찾기
    private int[] findResult(List<int[]> combinations) {
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < combinations.size(); i++) {
            int diff = combinations.get(i)[1] - combinations.get(i)[0];
            if (max < diff) {
                max = diff;
                maxIndex = i;
            }
        }
        return combinations.get(maxIndex);
    }

    private void printResult(int[] result, int input) {
        sb.append(input + " = " + result[0] + " + " + result[1]);
        System.out.println(sb);
        sb.setLength(0); // sb 초기화
    }
}
