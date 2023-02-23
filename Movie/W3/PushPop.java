import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class PushPop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int numbers = 1;

        Stack<Integer> Sequence = new Stack<>();
        Sequence.push(0);

        Boolean possible = true;

        for(int i = 1; i <= T; i++){
            if (possible) {
                int n = Integer.parseInt(br.readLine());
                while(numbers <= n){
                    Sequence.push(numbers);
                    numbers++;
                    sb.append("+\n");
                }
                if (n !=Sequence.peek()){
                    possible = false;
                }else {
                    Sequence.pop();
                    sb.append("-\n");
                }
            }

        }

        if (possible){
            System.out.print(sb);
        } else {
            System.out.print("NO");
        }
    }
}
