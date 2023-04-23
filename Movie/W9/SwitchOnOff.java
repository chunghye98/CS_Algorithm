package W9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwitchOnOff {
    static int[] switches;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(br.readLine());
        switches = new int[switchCount + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchCount; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentCount = Integer.parseInt(br.readLine());


        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (student == 1) {
                for (int j = number; j <= switchCount; j += number) {
                    switchChange(j);
                }
            } else {
                switchChange(number);
                for (int j = 1; j <= switchCount; j++){
                    if(j + number <= switchCount && number - j > 0 && switches[number - j] == switches[number + j]){
                        switchChange(number - j);
                        switchChange(number + j);
                    } else{
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int max = 20;
        int count = 0;
        for (int i = 1; i <= switchCount; i++) {
            count++;
            if (count == max) {
                count = 0;
                sb.append(switches[i]).append("\n");
            } else {
                sb.append(switches[i]).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);

    }


    private static void switchChange(int i) {
        if (switches[i] == 1) {
            switches[i] = 0;
        } else {
            switches[i] = 1;
        }
    }
}
