
> 처음에는 단순히 여는 괄호("("), 닫는 괄호(")") 개수 비교를 생각했는데 빠른 시간 안에 잘못됐다는 것을 알았다.  
> 단순히 개수만 비교하면 "))))(((("도 true가 나오게 된다.

이후 개수와 함께 누적합 비슷하게 풀 수 있을 것같았다.

> 코드 설명  
> - `(` 문자가 나오면 count에 +1을 한다.
> - `)` 문자가 나오면 count에 -1을 한다.
> - 연산 중 count가 음수가 되면 "NO"를 반환한다. (`)` 문자가 `(` 문자보다 먼저 나온 경우
> - 연산 결과가 0이 아니면 "NO"를 반환한다. (괄호의 짝이 맞지 않다는 뜻, `(` 문자로 끝난다.)
> - 연산 결과가 0이면 "YES"를 반환한다.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static String solve(String input) {

        int count = 0;

        for (char c : input.toCharArray()) {
            if (c == '(') {
                count++;
            }
            if (c == ')') {
                count--;
                if (count < 0) {
                    return "NO";
                }
            }
        }

        if (count != 0) {
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();

            System.out.println(solve(input));
        }
    }
}
```

## 본 코드의 한계
> 괄호의 종류가 `()` 뿐만 아니라 `[], {}` 등이 포함되어 있다면 해결할 수 없다.  
> 그럼 어떻게 해야할 까?
> 1. 일반적인 풀이인 Stack을 사용한다.
>    - 역시 일반적인 풀이가 된 이유가 있구나...
> 2. enum을 사용한다?
>    - 해봐야 알 것같다..
> 3. HashMap
>    - 음... 생각해보니까 enum이랑 HashMap 비슷한 느낌이 조금 있네??!!
