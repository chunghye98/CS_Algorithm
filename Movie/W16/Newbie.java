package W16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.*;

public class Newbie {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            Map<Integer, Integer> sMap = new HashMap<>();
            Map<Integer, Integer> mMap = new HashMap<>();
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int sungJeok = Integer.parseInt(st.nextToken());
                int myeonJeob = Integer.parseInt(st.nextToken());
                sMap.put(sungJeok, myeonJeob);
                mMap.put(myeonJeob, sungJeok);
            }

            if(N == 1){
                sb.append(1).append("\n");
                break;
            }
            int newbieCount = 0;
            for (Integer k : sMap.keySet()) {
                if (sMap.get(k) <= sMap.get(1) && mMap.get(sMap.get(k)) <= mMap.get(1)) {
                    newbieCount++;
                }
            }
            sb.append(newbieCount).append("\n");
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1));


    }
}
