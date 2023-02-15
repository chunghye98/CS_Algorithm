package BOJ.n1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 에디터 - 시간초과 => O(1) 이어야함.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 이게 문젠가
        List<String> stringList = new ArrayList<>(List.of(br.readLine().split("")));
        int instructionNumber = Integer.parseInt(br.readLine());
        int cursor = stringList.size(); // cursor 의 index 위치

        while (instructionNumber-- > 0) {
            String[] instruction = br.readLine().split(" ");

            // 이게 문젠가
            switch (instruction[0]) {
                // 커서의 위치를 왼쪽으로 바꾼다.
                case "L" :
                    if (cursor > 0) cursor--;
                    break;
                // 커서의 위치를 오른쪽으로 바꾼다.
                case "D" :
                    if (cursor < stringList.size()) cursor++;
                    break;
                // 커서의 왼쪽 요소를 지운다.
                case "B" :
                    if (cursor > 0) {
                        stringList.remove(cursor-1);
                        cursor--;
                    }
                    break;
                // instruction[1] 의 값을 커서의 왼쪽에 삽입한다.
                case "P" :
                    stringList.add(cursor, instruction[1]);
                    cursor++;
                    break;
            } // switch - end
        } // while - end

        for (String ch : stringList) {
            sb.append(ch);
        }

        System.out.println(sb);

    }
}
