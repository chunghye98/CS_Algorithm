import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 킹_1063 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] king = st.nextToken().toCharArray();
        char[] dol = st.nextToken().toCharArray();
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();

            char[] kingPrev = new char[2];
            kingPrev[0] = king[0];
            kingPrev[1] = king[1];

            if (validateMovable(king, cmd)) {
                king = move(king, cmd);

                if (validateEqual(king, dol)) {
                    if (validateMovable(dol, cmd)) {
                        dol = move(dol, cmd);
                    } else {
                        king = kingPrev;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(king[0]).append(king[1]).append("\n");
        sb.append(dol[0]).append(dol[1]);
        System.out.println(sb);
    }

    private static char[] move(char[] pos, String command) {
        switch (command) {
            case "R":
                pos[0]++;
                break;
            case "L":
                pos[0]--;
                break;
            case "B":
                pos[1]--;
                break;
            case "T":
                pos[1]++;
                break;
            case "RT":
                pos[0]++;
                pos[1]++;
                break;
            case "LT":
                pos[0]--;
                pos[1]++;
                break;
            case "RB":
                pos[0]++;
                pos[1]--;
                break;
            case "LB":
                pos[0]--;
                pos[1]--;
                break;
        }
        return pos;
    }

    private static boolean validateMovable(char[] pos, String command) {

        if (pos[0] == 'A' && command.contains("L")) {
            return false;
        }
        if (pos[1] == '1' && command.contains("B")) {
            return false;
        }
        if (pos[0] == 'H' && command.contains("R")) {
            return false;
        }
        if (pos[1] == '8' && command.contains("T")) {
            return false;
        }
        return true;
    }
    private static boolean validateEqual(char[] king, char[] dol) {
        return king[0] == dol[0] && king[1] == dol[1];
    }
}
