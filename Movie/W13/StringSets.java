package W13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
해쉬 테이블에서 contains메소드를 사용하는게 좋음.
각 요소마다 해쉬값이 생성되는 hash function이 사용되기 때문에 같은 값이 들어오면 같은 해쉬 값을 생성하기 때문에
평균적으로 O(1)로 찾을 수 있음. 하지만 다른 요소지만 같은 해쉬 값이 생성되는 경우도 있어서 최악의 경우는 O(n)이 걸림
 */
public class StringSets {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        Deque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            deque.add(br.readLine());
        }


        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int resultCount = 0;

        for (String str : deque) {
            if (map.containsKey(str)) {
                resultCount += map.get(str);
            }
        }

        System.out.println(resultCount);

    }
}
