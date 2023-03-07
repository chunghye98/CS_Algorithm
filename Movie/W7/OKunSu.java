package W7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OKunSu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque();
        int[] result = new int[T];

        deque.addLast(0);
        for(int i = 0; i < T; i++){
            if (list.size() <= i){
                int a = Integer.parseInt(st.nextToken());
                list.add(a);
            }


            boolean notFound = true;
            for (int j = i + 1; j < T; j++){
                if (list.size() <= j){
                    int b = Integer.parseInt(st.nextToken());
                    list.add(b);
                }

                if(list.get(deque.peekLast()) >= list.get(j)){
                    deque.addLast(j);
                } else {

                    while (!deque.isEmpty() && list.get(deque.peekLast()) < list.get(j)){
                        result[deque.pollLast()] = list.get(j);
                    }
                    deque.addLast(j);
                }

                if(result[i] != 0){
                    i = j - 1;
                    notFound = false;
                    break;
                } else if (j == T - 1) {
                    i = j;
                    int size = deque.size();
                    for(int k = 0; k < size; k++){
                        result[deque.pollFirst()] = -1;
                    }

                }



            }
            if(notFound){
                result[i] = -1;
            }
        }

        for(Integer n : result){
            sb.append(n).append(" ");
        }


        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }
}
