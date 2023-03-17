import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 킹
- 시간제한: 2초
- 움직이는 횟수 N <= 50
- 체스판 범위 넘어가지 못함
- 가려는 길에 돌이 있으면 못 감
-> 여기서 막힘
-> 깊은복사 얕은복사 학습 후 적용
-> 이전 위치 적용 시 문제가 있었다.
 */
public class A_1063 {
    public static String[] rowLocations = {"", "A", "B", "C", "D", "E", "F", "G", "H"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        String king = inputs[0];
        String rock = inputs[1];
        int moveN = Integer.parseInt(inputs[2]);

        int[] kingLocation = findLocation(king);
        int[] rockLocation = findLocation(rock);

        int[][] results;
        for (int i = 0; i < moveN; i++) {
            String location = br.readLine();
            results = move(kingLocation, rockLocation, location);
            kingLocation = results[0];
            rockLocation = results[1];
        }
        System.out.println(convertIntegerToString(kingLocation));
        System.out.println(convertIntegerToString(rockLocation));
    }

    private static String convertIntegerToString(int[] pieceLocation) {
        StringBuilder sb = new StringBuilder();
        sb.append(rowLocations[pieceLocation[0]]);
        sb.append(pieceLocation[1]);
        return sb.toString();
    }

    private static int[][] move(int[] kingLocation, int[] rockLocation, String location) {
        int[] clonedKing = kingLocation.clone();
        int[] clonedRock = rockLocation.clone();
        int[] movedKing = moveTo(location, clonedKing);
        int[] movedRock = clonedRock;

        if (!checkRange(movedKing)) {
            movedKing = kingLocation;
        }

        if (movedKing[0] == movedRock[0] && movedKing[1] == movedRock[1]) {
            movedRock = moveTo(location, movedRock);
            if (!checkRange(movedRock)) {
                return new int[][]{kingLocation, rockLocation};
            }
        }
        return new int[][]{movedKing, movedRock};
    }
    private static int[] moveTo(String location, int[] pieceLocations ) {
        switch (location) {
            case "R":
                pieceLocations[0]++;
                break;
            case "L":
                pieceLocations[0]--;
                break;
            case "B":
                pieceLocations[1]--;
                break;
            case "T":
                pieceLocations[1]++;
                break;
            case "RT":
                pieceLocations[0]++;
                pieceLocations[1]++;
                break;
            case "LT":
                pieceLocations[0]--;
                pieceLocations[1]++;
                break;
            case "RB":
                pieceLocations[0]++;
                pieceLocations[1]--;
                break;
            case "LB":
                pieceLocations[0]--;
                pieceLocations[1]--;
                break;
        }
        return pieceLocations;
    }

    public static boolean checkRange(int[] pieceLocation) {
        if (pieceLocation[0] > 0 && pieceLocation[0] < 9 && pieceLocation[1] > 0 && pieceLocation[1] < 9) {
            return true;
        }
        return false;
    }

    private static int[] findLocation(String king) {
        String[] location = king.split("");
        int[] resultLocation = new int[2];
        for (int i = 1; i < rowLocations.length; i++) {
            if (rowLocations[i].equals(location[0])) {
                resultLocation[0] = i;
                break;
            }
        }
        resultLocation[1] = Integer.parseInt(location[1]);
        return resultLocation;
    }
}
