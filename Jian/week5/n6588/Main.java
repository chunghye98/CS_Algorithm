package BOJ.week5.n6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 골드바흐의 추측
// 첫번째 시도: Eratos() 안에서 true인 element만 찾아서 새로운 배열에 저장함. (Math.sqrt()의 영향으로 1000 이하 소수만 저장됨.) - 틀림
// 두번째 시도: Eratos() 에서 구한 List들을 makePrimeList()를 이용해서(true인 element만 찾아) 새로운 배열에 저장.(1000,000 이하 소수 전부 저장됨) - 시간초과
// 세번째 시도: Eratos() 에서 구한 List들을 정렬하지 않고 계산. - 시간 초과
// 네번째 시도: 구글 검색. 내 코드를 조금만 바꾸면 되는 블로그를 발견해서 적용. - 시간초과 (장난하냐..)
// 다섯번째 시도: 세번째 시도에서 Eratos()의 초기화용 true를 삭제하고, 소수일 경우 true -> false 로 재설정함. (시간초과 절약) - 성공!

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] primeList = Eratos(1000000);

        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            sb.append(Goldbach(primeList, n));
        }

        System.out.println(sb);
    }

    public static boolean[] Eratos(int limitNumber){
        boolean[] primes = new boolean[limitNumber+1];
        primes[0] = true;
        primes[1] = true;

        for (int i = 2; i <= Math.sqrt(limitNumber); i++) {
            if (!primes[i]) {
                for (int j = i*i; j <= limitNumber; j += i) {
                    primes[j] = true;
                } // for2
            } // if
        } // for1

        return primes;
    } // Eratos()

    public static String Goldbach(boolean[] primeList, int n){
        for (int i = n; i > 0; i--) {
            int minNum = n - i;
            if (!primeList[i] && !primeList[minNum]) {
                return (n + " = " + minNum + " + " + i + "\n");
            }
        }
        return ("Goldbach's conjecture is wrong.\n");
    } // Goldbach()
}
