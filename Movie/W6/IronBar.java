package Movie.W6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IronBar {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '('){
                if (input.charAt(i + 1) != ')'){
                    stack.push(1);
                    count++;
                }else {
                    if(!stack.isEmpty()){
                        i = i + 1;
                        count += stack.size();
                    }
                }
            } else {
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }

        }
        System.out.println(count);
    }
}
