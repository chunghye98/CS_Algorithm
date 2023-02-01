package BOJ.n10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputRepeatNum = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>();
        List<Integer> resultOut = new ArrayList<>();

        while (inputRepeatNum > 0) {
            String str = br.readLine();
            String[] strArr = str.split(" ");

            executeStack(strArr, stack, resultOut);

            inputRepeatNum--;
        } // while - end
        br.close();

        for (int a : resultOut) {
            System.out.println(a);
        }
    } // main - end

    public static void executeStack(String[] strArr, List<Integer> stack, List<Integer> resultOut){
        String instructionWord = strArr[0];

        switch (instructionWord) {
            case "push":
                stack.add(Integer.parseInt(strArr[1]));
                break;
            case "pop":
                if (stack.size() > 0) {
                    resultOut.add(stack.remove(stack.size() - 1));
                } else {
                    resultOut.add(-1);
                }
                break;
            case "size":
                resultOut.add(stack.size());
                break;
            case "empty":
                int emptyResult = (stack.size() == 0) ? 1 : 0;
                resultOut.add(emptyResult);
                break;
            case "top":
                if (stack.size() > 0) {
                    resultOut.add(stack.get(stack.size() - 1));
                } else {
                    resultOut.add(-1);
                }
                break;
        } // switch - end

    } // executeStack() - end
} // class - end
