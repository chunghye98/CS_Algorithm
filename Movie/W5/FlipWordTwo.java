package Movie.W5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlipWordTwo {
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
        String S = br.readLine();
        String[] strs = S.split("(?<=>)|(?=<)");
        StringBuilder sb = new StringBuilder();
        for (String s : strs){
            if (s.charAt(0) != '<'){
                StringTokenizer st = new StringTokenizer(s);
                while(st.hasMoreTokens()){
                    sb.append(Flip(st.nextToken()));
                    if (st.hasMoreTokens()){
                        sb.append(" ");
                    }
                }
            }else {
                sb.append(s);
            }
        }
        System.out.println(sb);


    }
}
