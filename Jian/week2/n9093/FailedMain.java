package BOJ.n9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 런타임 에러 - main class Main. 이유를 모르겠다ㅠ
public class FailedMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int recursiveNumber = Integer.parseInt(br.readLine());
        StringBuilder resultString = new StringBuilder();

        int i = 0;
        while (i < recursiveNumber) {
            String[] sentence = br.readLine().split(" ");
            StringBuilder temp = new StringBuilder();

            for (String word: sentence) {
                for (int j = word.length()-1; j >= 0; j--) {
                    char ch = word.charAt(j);
                    temp.append(ch);
                } // for2 - end
                if (!word.equals(sentence[sentence.length-1])) {
                    temp.append(" ");
                } // if - end
            } // for1 - end
            temp.append("\n");
            resultString.append(temp);
            i++;
        } // while - end

        System.out.print(resultString);
    } // main - end
} // class - end
