package W14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class LastFreedom {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> weights = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if(weight <= K){
                map.put(weight, Math.max(map.getOrDefault(weight, 0), value));
                weights.add(weight);
            }
        }
        Collections.sort(weights);
        PriorityQueue<Integer> bag = new PriorityQueue<>(Comparator.naturalOrder());
        bag.add(weights.get(0));
        for(int i = 1; i < weights.size(); i++){
            List<Integer> temp = new ArrayList<>();
            for(Integer n : bag){
                int sum = n + weights.get(i);
                if(sum <= K){
                    temp.add(sum);
                    map.put(sum, Math.max(map.get(weights.get(i)) + map.get(n), map.getOrDefault(sum, 0)));
                } else {
                    break;
                }
            }
            bag.add(weights.get(i));
            bag.addAll(temp);

        }
        int max = 0;
        for (int key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
            }
        }

        System.out.println(max);


    }

}
