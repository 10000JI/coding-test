package Baekjoon.step12;

import java.io.*;
import java.util.StringTokenizer;

public class ExampleFour {
    //보드에서 8x8 크기
    public static int min = 64;
    public static boolean[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //arr[i][j]는 i행 j열의 칸이 'W'이면 true, 'B'이면 false를 저장
        arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        ////보드에서 8x8 크기의 부분을 선택
        int N_row = n - 7;
        int M_col = m - 7;

        //체스판 패턴에 맞게 다시 칠해야 하는 정사각형의 개수를 구하는 함수인 find를 호출
        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    // find 함수는 시작점 (x, y)를 받아서 해당 위치부터 8x8 크기의 부분을 검사
    public static void find(int x, int y) {
        // 해당 위치부터 8x8 크기의 부분
        int end_x = x + 8;
        int end_y = y + 8;
        //해당 부분을 다시 칠해야 하는 정사각형의 개수
        int count = 0;

        // 현재 칸의 색을 나타내며, 첫 번째 칸의 색으로 초기화
        boolean TF = arr[x][y];

        //이중 반복문을 통해 해당 부분을 모두 검사하면서, 각 칸의 색이 TF와 다르면 count를 증가
        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (arr[i][j] != TF) {
                    count++;
                }
                //한 행이 끝나면 TF를 반전시켜서 다음 행의 첫 번째 칸의 색과 동일하게 만듬
                TF = (!TF);
            }
            TF = (!TF);
        }

        //count와 (64 - count) 중 작은 값을 선택하여 최종적으로 count에 저장
        //이는 첫 번째 칸의 색과 반대되는 색을 기준으로 했을 때의 경우도 고려한 것
        count = Math.min(count, 64 - count);
        // 최소값인 min을 출력
        min = Math.min(min, count);
    }
}
