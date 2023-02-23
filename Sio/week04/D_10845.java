import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 큐
- queue 사용
- back 출력을 위해 push할 때마다 값을 넣는 변수 생성
 */
public class D_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int test = Integer.parseInt(br.readLine());
        int back = -1;
        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    int input = Integer.valueOf(st.nextToken());
                    queue.add(input);
                    back = input;
                    break;
                case "pop":
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.peek());
                    break;
                case "back":
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(back);
                    break;
            }
        }
    }
}
