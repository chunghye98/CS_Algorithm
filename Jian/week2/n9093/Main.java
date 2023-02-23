package BOJ.n9093;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int recursiveNumber = Integer.parseInt(br.readLine());

        while (recursiveNumber-- > 0) {
            Stack<Character> stack = new Stack<>();
            String sentence = br.readLine() + "\n";
            for (char ch : sentence.toCharArray()) {
                if (ch == ' ' || ch == '\n') {
                    while (!stack.isEmpty()){
                        bw.write(stack.pop());
                    } // while - end
                    bw.write(ch);
                } // if - end
                else stack.push(ch);
            } // for - end
        } // while - end

        bw.close();
    } // main - end
} // class - end
