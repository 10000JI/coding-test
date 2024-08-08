package didim365;

import java.io.*;
import java.util.*;

public class CustomProcedurePuzzle_8_Success {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String goalBoard;
    static char[][] board;
    static int[] moveRow = {-1, 0, 1, 0};
    static int[] moveCol = {0, 1, 0, -1};
    static HashMap<Integer, Integer> visitMap = new HashMap<>(); //한 번의 테스트 시 방문 여부 체크: 순서X 중복(키X,값O)
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        System.out.println("아래에 목표 노드를 3x3 형태로 입력해주세요. (빈 퍼즐은 숫자 대신 #을 입력해주세요)");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(br.readLine());
        }
        goalBoard = sb.toString().replace('#', '9');
        System.out.println("아래에 시작 노드를 3x3 형태로 입력해주세요. (빈 퍼즐은 숫자 대신 #을 입력해주세요)");
        insert(); //입력
        boolean reachedGoal = aStar(); //a* 알고리즘
        if (reachedGoal) {
            bw.write(String.valueOf("최소한의 이동 횟수: "+visitMap.get(Integer.parseInt(goalBoard))+ "\n"));
        } else {
            bw.write("해당 시작노드는 목표노드로 이동할 수 없습니다." + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean aStar() throws IOException {
        StringBuilder stepsLog = new StringBuilder(); // 성공 시 출력할 로그를 저장

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            String currentData = currentNode.data;
            int currentStep = currentNode.g; // 현재 노드의 깊이

            if (currentData.equals(goalBoard)) {
                //목표 노드까지 stringbuilder에 추가
                consoleLog(stepsLog, currentStep, goalBoard);
                bw.write(stepsLog.toString());
                // 목표 상태에 도달했을 때만 로그를 출력
                bw.write("목표 상태에 도달했습니다!\n");
                return true;
            }
            //시작 노드부터 목표노드 이전까지 선택된 노드를 stringbuilder에 추가
            consoleLog(stepsLog, currentStep, currentData);

            int emptyPlaceIndex = currentData.indexOf("9");
            int currentRow = emptyPlaceIndex / 3;
            int currentCol = emptyPlaceIndex % 3;

            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + moveRow[i];
                int newCol = currentCol + moveCol[i];
                if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                    StringBuilder nextData = new StringBuilder(currentData);
                    nextData = swap(currentRow, currentCol, newRow, newCol, nextData);
                    String data = nextData.toString();

                    if(visitMap.containsKey(Integer.parseInt(data))) continue; //이미 본 케이스라면 건너뛴다.
                    else {
                        int g = currentStep + 1; //경로가중치+1
                        int h = getHeuristic(data);
                        int f = g + h;
                        pq.add(new Node(data, g, f));
                        visitMap.put(Integer.parseInt(data), g);
                    }
                }
            }
        }
        return false;
    }

    private static void consoleLog(StringBuilder stringBuilder, int step, String data) {
        stringBuilder.append("step: " + step).append("\n");
        String replaceData = data.replace('9', '#');
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(replaceData.substring(i * 3, i * 3 + 3)).append("\n");
        }
        stringBuilder.append("---------").append("\n");
    }


    private static int getHeuristic(String data) {
        // 목표노드 인덱스 위치의 숫자 값이 동일한지 확인 (h(n)은 작을 수록 좋은 것)
        // 휴리스틱 방법 Manhattan Distance로 해도 상관없음
        int cnt = 0;
        for (int i = 0; i < data.length(); i++) {
            if (goalBoard.charAt(i) != data.charAt(i)) cnt++; //같은 위치에 같은 숫자가 아니라면 cnt++
        }
        return cnt;
    }

    private static StringBuilder swap(int currentRow, int currentCol, int newRow, int newCol, StringBuilder nextData) {
        int currentRC = currentRow * 3 + currentCol; //이차원 배열의 row, col 을 nextData에서 추출 가능하게 일차원 형태로 변환 (빈공간 위치 인덱스)
        int nextRC = newRow * 3 + newCol; //이차원 배열의 row, col 을 nextData에서 추출 가능하게 일차원 형태로 변환 (변경할 값이 있는 인덱스)
        char temp = nextData.charAt(currentRC);
        nextData.setCharAt(currentRC, nextData.charAt(nextRC));
        nextData.setCharAt(nextRC, temp);
        return nextData;
    }

    private static void insert() throws IOException {
        board = new char[3][3];
        String str = "";
        for (int row = 0; row < 3; row++) {
            board[row] = br.readLine().toCharArray();
            for (int col = 0; col < 3; col++) {
                if(board[row][col] == '#') board[row][col] = '9'; //#은 빈공간이나 이를 9로 치환(Integer.parseInt 해야 함)
                str += board[row][col];
            }
        }
        pq.add(new Node(str, 0, 0));
        visitMap.put(Integer.parseInt(str), 0);
    }

    static class Node implements Comparable<Node>{
        String data;
        int g; //g(n)
        int f; //f(n)

        @Override
        public int compareTo(Node o) {
            if(f == o.f) return Integer.compare(g, o.g); //f(n)이 동일하다면 이동 횟수가 작은 수 석택
            return Integer.compare(f, o.f); //f(n)기준으로 작은 수 선택
        }

        public Node(String data, int g, int f) {
            this.data = data;
            this.g = g;
            this.f = f;
        }
    }
}
