import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_1913 {
    private static String direction;
    private static int[][] map;
    private static int n;
    private static int target;
    private static int num;
    private static Point targetP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringBuilder sb = new StringBuilder();

        num = n * n;
        direction = "down";
        Point p = new Point(0, 0);
        while (num > 0) {
            if (direction.equals("down")) {
                p = toDown(p);
            }

            if (direction.equals("right")) {
                p = toRight(p);
            }

            if (direction.equals("up")) {
                p = toUp(p);
            }

            if (direction.equals("left")) {
                p = toLeft(p);
            }
        }

        for (int[] m : map) {
            for (int i : m) {
                sb.append(i + " ");
            }
            sb.append("\n");
        }
        sb.append((targetP.y + 1) + " " + (targetP.x + 1));
        System.out.println(sb);
    }

    private static Point toLeft(Point p) {
        try {
            while ((p.y < n && p.x < n && p.y >= 0 && p.x >= 0) && num > 0) {
                map[p.y][p.x] = num;
                if (num == target) {
                    targetP = new Point(p.x, p.y);
                }
                p.x--;
                num--;
                if (map[p.y][p.x] != 0) {
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }finally {
            p.x++;
            p.y++;
            direction = "down";
            return p;
        }
    }

    private static Point toUp(Point p) {
        try {
            while ((p.y < n && p.x < n && p.y >= 0 && p.x >= 0) && num > 0 ) {
                map[p.y][p.x] = num;
                if (num == target) {
                    targetP = new Point(p.x, p.y);
                }
                p.y--;
                num--;
                if (map[p.y][p.x] != 0) {
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }finally {
            p.y++;
            p.x--;
            direction = "left";
            return p;
        }
    }

    private static Point toRight(Point p) {
        try {
            while ((p.y < n && p.x < n && p.y >= 0 && p.x >= 0) && num > 0) {
                map[p.y][p.x] = num;
                if (num == target) {
                    targetP = new Point(p.x, p.y);
                }
                p.x++;
                num--;
                if (map[p.y][p.x] != 0) {
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }finally {
            p.x--;
            p.y--;
            direction = "up";
            return p;
        }
    }

    private static Point toDown(Point p) {
        try {
            while ((p.y < n && p.x < n && p.y >= 0 && p.x >= 0) && num > 0) {
                map[p.y][p.x] = num;
                if (num == target) {
                    targetP = new Point(p.x, p.y);
                }
                p.y++;
                num--;
                if (map[p.y][p.x] != 0) {
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }finally {
            p.y--;
            p.x++;
            direction = "right";
            return p;
        }
    }
}
