package Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class VPS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <T; i++){
            int isVPS = 0;
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++){
                if (str.charAt(j) == '('){
                    isVPS++;
                } else {
                    isVPS--;
                }
                if (isVPS < 0){
                    break;
                }


            }
            if (isVPS == 0){
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}
