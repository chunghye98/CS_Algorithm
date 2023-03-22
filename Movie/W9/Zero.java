package W9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            if(n != 0){
                stack.push(n);
            }else{
                stack.pop();
            }
        }

        int result = 0;
        for(int n : stack){
            result+= n;
        }

        System.out.println(result);


    }
}
