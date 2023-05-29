package week15;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
//        String[] board ={"MME", "EEE", "EME"}; 0, 0
        String[] board ={"EEEEE", "EEMEE", "EEEEE", "EEEEE"};
        int x = 0;
        int y = 0;

        int n = board.length;
        String[] answer = new String[n];
        String[][] splitedBoard = new String[board.length][];
        for (int i = 0; i < board.length; i++) { // 삽입
            splitedBoard[i] = board[i].split("");
        }
        Boolean[][] visited = new Boolean[board.length][splitedBoard[0].length];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        Queue<Point> queue = new LinkedList<>();

        // 바로 지뢰를 발견 한 경우
        if (splitedBoard[x][y].equals("M")) {
            splitedBoard[x][y] = "X";
            board[x] = String.join("", splitedBoard[x]);

            for (String str: board) {
                System.out.println(str);
            }
            return;
        }

        // 실행
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point point = queue.poll(); // 현재 좌표
            visited[point.x][point.y] = true; // 방문 표시

            if (splitedBoard[point.x][point.y].equals("E")) { // 현재 위치가 "E" 일 때만 주변을 파악한다.
                Point[] aroundPoints = findAroundPoints(point.x, point.y, visited, board.length, splitedBoard[0].length);
                Arrays.stream(aroundPoints).filter(p -> splitedBoard[p.x][p.y].equals("E")).forEach(p -> queue.add(p)); // queue에 p를 넣는다.

                int countE = (int) Arrays.stream(aroundPoints).filter(p -> splitedBoard[p.x][p.y].equals("E")).count();
                if (countE == aroundPoints.length) { // 주변이 다 E라면
                    splitedBoard[point.x][point.y] = "B"; // B를 넣고
                } else { // 주변에 "M"이 있다는 뜻이므로
                    splitedBoard[point.x][point.y] = String.valueOf(aroundPoints.length - countE);
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = String.join("", splitedBoard[i]);
        }

        System.out.println("board");
        for (String str: board) {
            System.out.println(str);
        }
        System.out.println("x: " + x + " y: " + y);
        System.out.println("answer");
        for (String str: answer) {
            System.out.println(str);
        }
    }

    static Point[] findAroundPoints(int currentX, int currentY, Boolean[][] visited, int lengthX, int lengthY){
        // 방문하지 않았으면서 board의 범위 내에 있어야 함.
        // 북, 북동, 동, 남동, 남, 남서, 서, 북서
        Point[] points = {new Point(1, 0), new Point(1, 1), new Point(0, 1), new Point(-1, 1),
                new Point(-1, 0), new Point(-1, -1), new Point(0, -1), new Point(1, -1)};

        List<Point> answerPoints = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            Point point = points[0];
            int nowX = point.x + currentX;
            int nowY = point.y + currentY;
            if ((nowX >= 0 && nowX < lengthX) && (nowY >= 0 && nowY < lengthY)){ // 범위 내
                if (!visited[nowX][nowY]) { // 방문하지 않았다면
                    answerPoints.add(new Point(nowX, nowY));
                }
            }
        }

        Point[] returnPoints = new Point[answerPoints.size()];
        for (int i = 0; i < answerPoints.size(); i++) {
            returnPoints[i] = answerPoints.get(i);
        }
        return returnPoints;
    }
}
