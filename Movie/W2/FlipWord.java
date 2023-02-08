package Movie.W2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FlipWord {

    // Stringbuilder에 reverse 메소드 따로 있음...
    private static String Flip(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0 ; i--){
            sb.append(s.charAt(i));

        }

        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(true){
                sb.append(Flip(st.nextToken()));

                if (st.hasMoreTokens()){
                    sb.append(" ");
                } else {
                    break;
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);


    }
}

