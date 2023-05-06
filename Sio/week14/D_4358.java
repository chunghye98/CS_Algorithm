import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/* 4358, 생태학
- 시간 제한: 1초
< 접근 방법 >
treeMap 사용하면 되는 문제
입력 없을 때까지 반복문 돌게 하는 조건식에서 조금 시간 걸림

1. 사전 순서대로 map 에 넣는다. 이미 있는 종이면 value+1만 put 한다. 없으면 value는 1로 put한다
2. map을 돌면서 백분율을 구해 출력한다.

 */
public class D_4358 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new TreeMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String treeName;
        int count = 0;
        while ((treeName = br.readLine()) != null && !treeName.equals("")) {
            if (map.containsKey(treeName)) {
                map.put(treeName, map.get(treeName) + 1);
            } else {
                map.put(treeName, 1);
            }
            count++;
        }

        for (String tree : map.keySet()) {
            double percent = (double )map.get(tree) / (double) count * 100.0;
            System.out.println(tree + " " + String.format("%.4f", percent));
        }
    }
}
