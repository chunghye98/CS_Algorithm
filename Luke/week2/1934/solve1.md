> ## solve1
> 효율적으로 최소공배수를 구하기 위해서 최대공약수를 구하는 것은 어쩔 수 없는 것같다.
> 
> A부터 0까지 for문을 돌면서 최대공약수를 구할 때 최악의 상황
> >T: 1000, A:44999, B:45000 // 1000번의 케이스 모두 44999, 45000 (44999{1000, 1000}45000)  
> > -> 최대 공약수는 1이므로 총 연산횟수는 약 45_000_000(4천5백만)이므로 시간 제한 안에 풀리긴 할 것이다.  
> > -> return (A * B) / (최대공약수)
>
> 하지만 효율적인 풀이라고 생각하지 않기 떄문에 다른 방법도 생각하려고 한다.

> 답은 맞다고 나왔는데 문제 잘못 푼 곳 이썽요...  
> 저는 A <= B 조건이 있는 줄 알았는데 아니네요...? 그래서 for문에 A부터 --하면서 돌린건데...  
> 문제 만드신 분들도 그게 중요한게 아니니까 테스트 케이스에 추가하지 않으신 것같아요?

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int solve(int A, int B) {

        // B가 A의 배수라면 B가 최소공배수다.
        if (B % A == 0) {
            return B;
        }
        
        // A가 B의 배수라면 A가 최소공배수다.
        if (A % B == 0) {
            return A;
        }

        int gcd = 1;
        for (int i = A; i > 1 ; i--) {
            if (A % i == 0 && B % i == 0) {
                gcd = i;
                break;
            }
        }

        return A * B / gcd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int A, B;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            System.out.println(solve(A, B));
        }
    }
}
```
