package W16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LostParentheses {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] parsedInput = input.split("(?=[-+])|(?<=[-+])");

        int result = 0;
        boolean minus = false;
        for (String str : parsedInput) {
            int num = -1;
            try {
                num = Integer.parseInt(str);
            } catch (NumberFormatException ignored) {
            }

            if (num != -1) {
                if (minus) {
                    result -= num;
                } else {
                    result += num;
                }
            }

            if (str.equals("-")) {
                minus = true;
            }

        }

        System.out.println(result);

    }
}
