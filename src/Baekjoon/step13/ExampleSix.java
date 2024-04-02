package Baekjoon.step13;

import java.io.*;
import java.util.*;

public class ExampleSix {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String n = br.readLine();
        char[] chr = new char[n.length()];
        for (int i = 0; i < n.length(); i++) {
            chr[i] = n.charAt(i);
        }
        Arrays.sort(chr);
        for (int i = chr.length - 1; i >= 0; i--) {
            sb.append(chr[i]);
        }
        System.out.println(sb);
    }
}
