package W14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TwoYongAek {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        int left = 0;
        int right = N -1;
        while(left < right ){
            int sum = list.get(left) +  list.get(right);
            if(Math.abs(sum) < min){
                minLeft = left;
                minRight = right;
                min = Math.abs(sum);
            }

            if(sum < 0){
                left++;
            } else if (sum > 0){
                right--;
            } else {
                break;
            }
        }

        System.out.println(list.get(minLeft) + " " + list.get(minRight));

    }
}
