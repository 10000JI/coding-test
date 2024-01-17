package section5;

import java.util.Scanner;
import java.util.Stack;

//크레인 인형뽑기(카카오)
public class ExampleThree {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        //pos는 1~5 숫자 (moves는 8 크기의 배열)
        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                //board 열의 인덱스 번호는 0부터 시작해야하므로 pos-1
                //인형이 발견되었을 때 (0이 아님)
                if (board[i][pos - 1] != 0) {
                    //인형의 번호를 가져옴
                    int tmp = board[i][pos - 1];
                    //인형의 번호를 가져온 뒤, 해당 위치의 board의 배열의 값은 0으로 변경
                    board[i][pos - 1] = 0;
                    //stack이 비어있지 않으면서, 인형의 번호와 stack의 상단의 값과 동일하면
                    //answer는 +2 해주고, pop() 꺼내서 삭제
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else stack.push(tmp); //그 외의 경우엔 stack에 한 층씩 저장
                    //moves의 담긴 배열의 숫자들(=pos)을 가지고 하기 때문에 안쪽 for문 break
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ExampleThree T = new ExampleThree();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }
        System.out.println(T.solution(board,moves));
    }
}
