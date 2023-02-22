package BOJ.week5.n6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 골드바흐의 추측
// 첫번째 시도: Eratos() 안에서 true인 element만 찾아서 새로운 배열에 저장함. (Math.sqrt()의 영향으로 1000 이하 소수만 저장됨.) - 틀림
// 두번째 시도: Eratos() 에서 구한 List들을 makePrimeList()를 이용해서(true인 element만 찾아) 새로운 배열에 저장.(1000,000 이하 소수 전부 저장됨) - 시간초과
// 세번째 시도: Eratos() 에서 구한 List들을 정렬하지 않고 계산. - 시간 초과
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Boolean> primeList = Eratos(1000000);

        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            sb.append(Goldbach(sb, primeList, n)).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);
    }

    public static List<Boolean> Eratos(int limitNumber){
        List<Boolean> primes = new ArrayList<>();
        primes.add(false); // 0
        primes.add(false); // 1

        for (int i = 2; i <= limitNumber; i++) { // 초기화
            primes.add(true);
        }

        for (int i = 2; i <= Math.sqrt(limitNumber); i++) {
            if (primes.get(i)) {
                for (int j = i*i; j <= limitNumber; j += i) {
                    primes.set(j, false);
                } // for2
            } // if
        } // for1

        return primes;
    } // Eratos()

//    public static List<Integer> makePrimeList(List<Boolean> primes){
//        List<Integer> primeList = new ArrayList<>();
//        for (int i = 0; i < primes.size(); i++) {
//            if (primes.get(i)) {
//                primeList.add(i);
//            }
//        }
//        return primeList;
//    }

    public static String Goldbach(StringBuilder sb, List<Boolean> primeList, int n){
        for (int i = 0; i < primeList.size(); i++) {
            for (int j = i; j < primeList.size(); j++) {
                if ((i + j == n) && (primeList.get(i) && primeList.get(j))) {
                    return (n + " = " + i + " + "+ j);
                }
            }
        }
        return ("Goldbach's conjecture is wrong.");
    } // Goldbach()
}
