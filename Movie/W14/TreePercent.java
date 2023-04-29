package W14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class TreePercent {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> map = new HashMap<>();

        int treeCount = 0;
        while(true){
            String tree = br.readLine();
            if(tree == null){
                break;
            }
            map.put(tree, map.getOrDefault(tree, 0.0) + 1);
            treeCount++;
        }

//        DecimalFormat df = new DecimalFormat("#.####"); //import java.text.DecimalFormat;
//        df.setRoundingMode(RoundingMode.UP); //import java.math.RoundingMode;

        TreeMap<String, Double> resultMap = new TreeMap<>();
        for(String key : map.keySet()){
            resultMap.put(key, (map.get(key)/treeCount) * 100);
        }


        StringBuilder sb = new StringBuilder();
        for(String key : resultMap.keySet()){
            sb.append(key).append(" ").append(String.format("%.4f", resultMap.get(key))).append("\n");
        }
        System.out.println(sb.deleteCharAt(sb.length() -1));






    }
}
