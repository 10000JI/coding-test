import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public String solution(int number, String str) {
        String answer = "";
        for (int i = 0; i < number; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            answer += (char) Integer.parseInt(tmp, 2);
            str = str.substring(7);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int number = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(number, str));
    }
}