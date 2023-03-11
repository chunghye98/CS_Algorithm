import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/* 숨바꼭질 6
- 시간 제한: 1초
- N은 10^5까지, S는 10^9, Ai는 10^9
- 시간복잡도가 O(n) 이하여야 한다

<로직>
- 입력받는다.
- 동생들 좌표는 List로 받는다.
- Math.abs(언니 좌표 - 동생 좌표)를 새로운 리스트에 넣는다.
- 리스트를 내림차순으로 정렬한다.
- 리스트를 돌면서 두 수의 최대공약수를 찾는다
    이후 리스트의 요소들을 구해진 최대공약수와 함께 새로운 최대공약수를 구한다.
- 마지막 최대공약수가 리스트의 모든 요소의 최대공약수이다.

<의문>
- for문 안에 재귀를 돌렸는데 그럼 O(n^2)이지 않나
- 시간 초과가 떠야 하지 않을까
- -> 유클리드 호제법의 O(logN)
- 전체 시간복잡도는 O(nlogn)
 */
public class B_17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> siblings = new ArrayList<>();
        while (st.hasMoreTokens()) {
            siblings.add(Integer.valueOf(st.nextToken()));
        }

        solve(s, siblings);
    }

    private static void solve(int s, List<Integer> siblings) {
        List<Integer> locationDiff = new ArrayList<>();
        for (Integer sibling : siblings) {
            locationDiff.add(Math.abs(s - sibling));
        }

        Collections.sort(locationDiff, Collections.reverseOrder());

        int commonFactor = locationDiff.get(0);
        for (int i = 1; i < locationDiff.size(); i++) {
            commonFactor = gcd(locationDiff.get(i), commonFactor);
        }

        System.out.println(commonFactor);
    }

    private static int gcd(int max, int min) {
        int r = max % min;
        if (r == 0) {
            return min;
        } else {
            return gcd(min, r);
        }
    }
}
