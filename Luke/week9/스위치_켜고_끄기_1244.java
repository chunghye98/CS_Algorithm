import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치_켜고_끄기_1244 {

    private static int[] switches;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        switches = new int[num + 1];

        switches[0] = 2;    // 대칭 비교할 때 구별하기 위한 장치
        for (int i = 1; i <= num; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int numOfStudents = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfStudents; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                switches = operateByMale(switches, index);
            } else {
                switches = operateByFemale(switches, index);
            }
        }

        for (int i = 1; i < switches.length; i++) {
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int[] operateByMale(int[] switches, int switchIndex) {
        for (int i = 1; switchIndex * i < switches.length; i++) {
            switches = changeSwitch(switches, switchIndex * i);
        }
        return switches;
    }

    private static int[] operateByFemale(int[] switches, int switchIndex) {

        int i = 0;
        switches = changeSwitch(switches, switchIndex);

        while (switches.length - 1 >= switchIndex + i && switchIndex - i >= 1) {
            if (switches[switchIndex + i] == switches[switchIndex - i]) {
                switches = changeSwitch(switches, switchIndex + i);
                switches = changeSwitch(switches, switchIndex - i);
                i++;
            } else {
                break;
            }
        }

        return switches;
    }

    private static int[] changeSwitch(int[] switches, int index) {
        if (switches[index] == 1) {
            switches[index] = 0;
        } else {
            switches[index] = 1;
        }
        return switches;
    }
}
