package BOJ.n9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// FailedMain을 다시 짜보았음. 성공함!
public class ReFailedMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int recursiveNumber = Integer.parseInt(br.readLine());
        StringBuilder resultString = new StringBuilder();

        while (recursiveNumber-- > 0) {
            String[] sentence = br.readLine().split(" ");
            StringBuilder temp = new StringBuilder();

            // 18 ~ 25번 라인. 리펙토링 한 부분
            for (String word: sentence) {
                StringBuilder wordBuilder = new StringBuilder(word);
                temp.append(wordBuilder.reverse());
                temp.append(" ");
            } // for - end

            temp.deleteCharAt(temp.length()-1); // 맨 마지막 공백 지우기
            temp.append("\n");
            resultString.append(temp);
        } // while - end

        System.out.print(resultString);
    } // main - end
} // class - end