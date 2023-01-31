import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 단어 뒤집기
   1. 입력 문자열을 공백 기준으로 배열 변환
   2. 각 문자를 StringBuffer의 reverse()를 사용해서 뒤집기
   3. 뒤집은 문자를 StringBuilder에 넣어서 리턴
 */
public class A_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            String[] split = input.split(" ");

            System.out.println(reverseWord(split));
        }
    }

    private static String reverseWord(String[] split) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            StringBuffer sbf = new StringBuffer(split[i]);
            sb.append(sbf.reverse());
            sb.append(" ");
        }
        return sb.toString();
    }
}
