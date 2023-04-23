package W8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KingBadNe {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] kingPos = new int[2];
        int[] stonePos = new int[2];
        String pos = st.nextToken();
        kingPos[0] = pos.charAt(0) - 'A';
        kingPos[1] = Integer.parseInt(String.valueOf(pos.charAt(1))) - 1;

        pos = st.nextToken();
        stonePos[0] = pos.charAt(0) - 'A';
        stonePos[1] = Integer.parseInt(String.valueOf(pos.charAt(1))) - 1;


        int N = Integer.parseInt(st.nextToken());

        boolean[][] chessBoard = new boolean[8][8];
        chessBoard[stonePos[0]][stonePos[1]] = true;


        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            switch (cmd) {
                case "R":
                    if (kingPos[0] + 1 < 8) {
                        if (chessBoard[kingPos[0] + 1][kingPos[1]]) {
                            if (stonePos[0] + 1 < 8) {
                                kingPos[0] = stonePos[0];
                                chessBoard[stonePos[0]][stonePos[1]] = false;
                                stonePos[0] += 1;
                                chessBoard[stonePos[0]][stonePos[1]] = true;
                            }
                        } else {
                            kingPos[0] += 1;
                        }
                    }
                    break;
                case "L":
                    if (kingPos[0] - 1 > -1) {
                        if (chessBoard[kingPos[0] - 1][kingPos[1]]) {
                            if (stonePos[0] - 1 > -1) {
                                kingPos[0] = stonePos[0];
                                chessBoard[stonePos[0]][stonePos[1]] = false;
                                stonePos[0] -= 1;
                                chessBoard[stonePos[0]][stonePos[1]] = true;
                            }
                        } else {

                            kingPos[0] -= 1;
                        }
                    }
                    break;
                case "B":
                    if (kingPos[1] - 1 > -1) {
                        if (chessBoard[kingPos[0]][kingPos[1] - 1]) {
                            if (stonePos[1] - 1 > -1) {
                                kingPos[1] = stonePos[1];
                                chessBoard[stonePos[0]][stonePos[1]] = false;
                                stonePos[1] -= 1;
                                chessBoard[stonePos[0]][stonePos[1]] = true;
                            }
                        } else {

                            kingPos[1] -= 1;
                        }
                    }
                    break;
                case "T":
                    if (kingPos[1] + 1 < 8) {
                        if (chessBoard[kingPos[0]][kingPos[1] + 1]) {
                            if (stonePos[1] + 1 < 8) {
                                kingPos[1] = stonePos[1];
                                chessBoard[stonePos[0]][stonePos[1]] = false;
                                stonePos[1] += 1;
                                chessBoard[stonePos[0]][stonePos[1]] = true;
                            }
                        } else {

                            kingPos[1] += 1;
                        }
                    }
                    break;
                case "RT":
                    if (kingPos[0] + 1 < 8 && kingPos[1] + 1 < 8) {
                        if (chessBoard[kingPos[0] + 1][kingPos[1] + 1]) {
                            if (stonePos[0] + 1 < 8 && stonePos[1] + 1 < 8) {
                                kingPos[0] = stonePos[0];
                                kingPos[1] = stonePos[1];
                                chessBoard[stonePos[0]][stonePos[1]] = false;
                                stonePos[0] += 1;
                                stonePos[1] += 1;
                                chessBoard[stonePos[0]][stonePos[1]] = true;
                            }
                        } else {

                            kingPos[0] += 1;
                            kingPos[1] += 1;
                        }
                    }
                    break;
                case "RB":
                    if (kingPos[0] + 1 < 8 && kingPos[1] - 1 > -1) {
                        if (chessBoard[kingPos[0] + 1][kingPos[1] - 1]) {
                            if (stonePos[0] + 1 < 8 && stonePos[1] - 1 > -1) {
                                kingPos[0] = stonePos[0];
                                kingPos[1] = stonePos[1];
                                chessBoard[stonePos[0]][stonePos[1]] = false;
                                stonePos[0] += 1;
                                stonePos[1] -= 1;
                                chessBoard[stonePos[0]][stonePos[1]] = true;
                            }
                        } else {

                            kingPos[0] += 1;
                            kingPos[1] -= 1;
                        }
                    }
                    break;
                case "LT":
                    if (kingPos[0] - 1 > -1 && kingPos[1] + 1 < 8) {
                        if (chessBoard[kingPos[0] - 1][kingPos[1] + 1]) {
                            if (stonePos[0] - 1 > -1 && stonePos[1] + 1 < 8) {
                                kingPos[0] = stonePos[0];
                                kingPos[1] = stonePos[1];
                                chessBoard[stonePos[0]][stonePos[1]] = false;
                                stonePos[0] -= 1;
                                stonePos[1] += 1;
                                chessBoard[stonePos[0]][stonePos[1]] = true;
                            }
                        } else {
                            kingPos[0] -= 1;
                            kingPos[1] += 1;
                        }
                    }
                    break;
                case "LB":
                    if (kingPos[0] - 1 > -1 && kingPos[1] - 1 > -1) {
                        if (chessBoard[kingPos[0] - 1][kingPos[1] - 1]) {
                            if (stonePos[0] - 1 > -1 && stonePos[1] - 1 > -1) {
                                kingPos[0] = stonePos[0];
                                kingPos[1] = stonePos[1];
                                chessBoard[stonePos[0]][stonePos[1]] = false;
                                stonePos[0] -= 1;
                                stonePos[1] -= 1;
                                chessBoard[stonePos[0]][stonePos[1]] = true;
                            }
                        } else {
                            kingPos[0] -= 1;
                            kingPos[1] -= 1;
                        }
                    }
                    break;
            }
        }

        String king = String.valueOf((char) (kingPos[0] + 'A')) + (kingPos[1] + 1);
        String stone = String.valueOf((char) (stonePos[0] + 'A')) + (stonePos[1] + 1);

        System.out.println(king);
        System.out.println(stone);





    }
}
