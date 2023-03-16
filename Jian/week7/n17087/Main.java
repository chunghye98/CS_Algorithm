package BOJ.week7.n17087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 숨바꼭질 6
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] youngerBrothers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int recurse = firstLine[0];
        int subin = firstLine[1];

        List<Integer> locations = new ArrayList<>();
        Set<Integer> distances = new HashSet<>();

        for (int brotherLocation : youngerBrothers){
            locations.add(brotherLocation);
        }
        locations.add(subin);
        Collections.sort(locations); // 유클리드 호제법 사용을 위한 정렬

        for (int i = 1; i < locations.size(); i++) { // 각 좌표 사이의 거리 구하기
            distances.add(locations.get(i) - locations.get(i-1));
        }

        List<Integer> finalList = new ArrayList<>(distances);
        int result = calculateResult(finalList); //  수에 따라 달라지는 값 판별
        System.out.println(result);

    }

    public static int calculateResult(List<Integer> finalList){
        if (finalList.size() == 0) {
            return 0;
        }
        if (finalList.size() == 1) {
            return finalList.get(0);
        }
        if (finalList.size() == 2) {
            return recurGCD(finalList.get(1), finalList.get(0));
        }
        // 2보다 클 때
        for (int i = 1; i < finalList.size(); i++) {
            finalList.set(i,recurGCD(finalList.get(i), finalList.get(i-1)));
        }
        return finalList.get(finalList.size()-1);
    }

    public static int recurGCD(int largeNumber, int smallNumber) { // 유클리드 호제법
        if (largeNumber % smallNumber == 0) {
            return smallNumber;
        }
        return recurGCD(smallNumber, largeNumber % smallNumber);
    }
}
