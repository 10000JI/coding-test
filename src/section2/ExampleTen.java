package section2;

import java.util.Scanner;

//봉우리
public class ExampleTen {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int n, int[][] arr) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    // 네방향의 값이 내 자신보다 크거나 같다면 나는 봉우리가 아니다! -> flag=false;
                    // 고로 for문을 빠져나가야 되므로 break;
                    // 인덱스를 -1번을 볼 수 있으므로 0부터 4까지 인덱스임을 명시해줘야 한다 ( 선행 조건 )
                    if (nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                //자기 자신이 네 방향 값보다 크면 봉우리이므로 answer++
                if (flag) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleTen T = new ExampleTen();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n,arr));
    }
}
