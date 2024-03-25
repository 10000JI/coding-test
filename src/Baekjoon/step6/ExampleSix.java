package Baekjoon.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExampleSix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        String[] strs = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
        for (String str : strs) {
            if (inputStr.contains(str)) {
                //replace(a,b) : a 문자를 b문자로 변경 (문자열도 가능)
                inputStr = inputStr.replace(str, "#");
            }
        }
        System.out.println(inputStr.length());
    }
}
