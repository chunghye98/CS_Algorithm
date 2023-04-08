package W11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Overtake {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<String> before = new Stack<>();
        Stack<String> after = new Stack<>();
        Deque<String> illegal = new ArrayDeque<>();

        for(int i = 0; i < N; i ++){
            before.add(br.readLine());
        }
        for(int i = 0; i < N; i ++){
            after.add(br.readLine());
        }

        for(int i = 0; i < N; i ++){
            while(illegal.contains(after.peek())){
                after.pop();
            }

            if(before.peek().equals(after.peek())){
                before.pop();
                after.pop();
            } else {
                illegal.add(before.pop());
            }
        }

        System.out.println(illegal.size());


    }

}
