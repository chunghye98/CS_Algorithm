package Movie.W5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Goldbach {

    private static List<Integer> PrimeList(int n) {
        List<Integer> PrimeList = new ArrayList<>();
        int [] check = new int[n+1];


        int max = (int) Math.pow(n, 0.5);
        for (int i = 2; i <= n; i ++){
            if (check[i] == 0){
                if (i != 2){
                    PrimeList.add(i);
                }
                if (i <= max){
                    for(int j = i + i; j < n; j += i){
                        if (check[j] == 0){
                            check[j] = 1;
                        }
                    }
                }
            }
        }

        return PrimeList;

    }
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> Pairs = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        while(n != 0){
            if (n > max){
                max = n;
            }
            Pairs.add(n);
            n = Integer.parseInt(br.readLine());
        }

        List<Integer> PrimeList = PrimeList(max);

        StringBuilder result = new StringBuilder();

        for(Integer N : Pairs){
            boolean RightOrWrong = false;
            int cutPoint = (int) Math.pow(N, 0.5);
            int a = 0;
            int b = 0;
            while (PrimeList.get(cutPoint) < N) {
                cutPoint++;

            }
                cutPoint--;

            for (int i = 0; i <= cutPoint; i++){
                if (PrimeList.get(i) + PrimeList.get(cutPoint - i) == N) {
                    a = PrimeList.get(i);
                    b = PrimeList.get(cutPoint - i);
                    RightOrWrong = true;
                    result.append(N + " = " + a + " + " + b + "\n");
                    break;
                }
            }
            if (RightOrWrong == false){
                result.append("Goldbach's conjecture is wrong.\n");
            }

        }
        System.out.println(result);


    }

}
