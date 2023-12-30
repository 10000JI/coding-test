package section2;

import java.util.Scanner;

// 임시반장
public class ExampleEleven {
    public int solution(int n, int[][] arr) {
        int answer = 0, max = Integer.MIN_VALUE;
        //i는 기준이 되는 학생 번호
        for (int i = 1; i <= n; i++) {
            //학생 번호가 바뀌면 cnt 초기화
            int cnt = 0;
            //j는 비교 대상이 되는 학생 번호
            for (int j = 1; j <= n; j++) {
                //k: 학년
                for (int k = 1; k <= 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        //k에 대한 for문이 종료
                        //동일한 번호의 학생이 다음 학년에 또 같은 반이 될 수 있으므로 break 걸어줌
                        break;
                    }
                }
            }
            //학생번호가 바뀌기 전에, 기존에 저장된 "같은 반이 되었던 학생 수"와 비교하여 크다면 max 값에 넣어주고, answer에는 학생 번호가 담긴다.
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleEleven T = new ExampleEleven();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n+1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
