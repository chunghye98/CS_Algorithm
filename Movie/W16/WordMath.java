package W16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordMath {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            list.add(br.readLine());
        }

        Map<Character, Integer> map = new HashMap<>();
        for(String str : list){
            int len = str.length() - 1;

            for(int i = 0; i < str.length(); i++){
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0) + (int) Math.pow(10,len));
                len--;
            }

        }

        Map<Character, Integer> resultMap = new HashMap<>();
        int number = 9;
        while(!map.isEmpty()){
            int max = Integer.MIN_VALUE;
            Character maxKey = null;
            for(Character c : map.keySet()){
                if(max < map.get(c)){
                    maxKey = c;
                    max = map.get(c);
                }
            }
            resultMap.put(maxKey, number);
            map.remove(maxKey);
            number--;
        }

        int resultSum = 0;
        for(String str : list){
            int len = str.length() - 1;
            for(int i = 0; i < str.length(); i++){
                resultSum +=resultMap.get(str.charAt(i)) * (int) Math.pow(10,len);
                len--;
            }
        }



        System.out.println(resultSum);



    }
}
