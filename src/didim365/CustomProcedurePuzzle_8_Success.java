package didim365;

import java.io.*;
import java.util.*;

public class CustomProcedurePuzzle_8_Success {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String startNode;
    static String goalNode;
    static int[] moveRow = {-1, 0, 1, 0};
    static int[] moveCol = {0, 1, 0, -1};
    static HashMap<String, Integer> visitMap = new HashMap<>(); //한 번의 테스트 시 방문 여부 체크: 순서X 중복(키X,값O)
    static PriorityQueue<Puzzle> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        System.out.println("아래에 목표 노드를 3x3 형태로 입력해주세요. (빈 퍼즐은 숫자 대신 #을 입력해주세요)"); //목표 노드 입력
        StringBuilder sbGoalBoard = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sbGoalBoard.append(br.readLine());
        }
        goalNode = sbGoalBoard.toString();

        System.out.println("아래에 시작 노드를 3x3 형태로 입력해주세요. (빈 퍼즐은 숫자 대신 #을 입력해주세요)"); //시작 노드 입력
        StringBuilder sbStartBoard = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sbStartBoard.append(br.readLine());
        }
        startNode = sbStartBoard.toString();

        //시작 노드 우선순위_큐에 담음 (f(n)=g(n)+h(n)이지만, g(n)이 0이므로 f(n)에는 h(n)만 대입)
        pq.add(new Puzzle(startNode, getHeuristic(startNode), 0, getHeuristic(startNode)));
        //시작 노드 재방문_방지_map에 저장
        visitMap.put(startNode, 0);

        boolean reachedGoal = aStar(); //a* 알고리즘
        if (reachedGoal) {
            bw.write(String.valueOf("최소한의 이동 횟수: "+visitMap.get(goalNode)+ "\n"));
        } else {
            bw.write("해당 시작노드는 목표노드로 이동할 수 없습니다." + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean aStar() throws IOException {
        StringBuilder stepsLog = new StringBuilder(); // 성공 시 출력할 로그를 저장
        stepsLog.append("\n");

        while (!pq.isEmpty()) {
            Puzzle currentPuzzle = pq.poll();
            String currentData = currentPuzzle.node;
            int currentStep = currentPuzzle.g; // 현재 노드의 깊이

            if (currentData.equals(goalNode)) {
                //목표 노드까지 stringbuilder에 추가
                consoleLog(stepsLog, currentPuzzle, goalNode);
                stepsLog.append("\n");
                bw.write(stepsLog.toString());
                // 목표 상태에 도달했을 때만 로그를 출력
                bw.write("목표 상태에 도달했습니다!\n");
                return true;
            }
            //시작 노드부터 목표노드 이전까지 선택된 노드를 stringbuilder에 추가
            consoleLog(stepsLog, currentPuzzle, currentData);

            int emptyPlaceIndex = currentData.indexOf("#");
            int currentRow = emptyPlaceIndex / 3;
            int currentCol = emptyPlaceIndex % 3;

            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + moveRow[i];
                int newCol = currentCol + moveCol[i];
                if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                    StringBuilder nextData = new StringBuilder(currentData);
                    nextData = swap(currentRow, currentCol, newRow, newCol, nextData);
                    String data = nextData.toString();

                    if(visitMap.containsKey(data)) continue; //이미 본 케이스라면 건너뛴다.
                    else {
                        int g = currentStep + 1; //경로가중치+1
                        int h = getHeuristic(data);
                        int f = g + h;
                        pq.add(new Puzzle(data, f, g, h));
                        visitMap.put(data, g);
                    }
                }
            }
        }
        return false;
    }

    private static void consoleLog(StringBuilder stringBuilder, Puzzle currentPuzzle, String data) {
        stringBuilder.append("(1) f(n): " + currentPuzzle.f+", g(n): " + currentPuzzle.g+", h(n): " + currentPuzzle.h).append("\n");
        stringBuilder.append("(2) 이동 횟수: " + currentPuzzle.g).append("\n");
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(data.substring(i * 3, i * 3 + 3)).append("\n");
        }
        stringBuilder.append("---------").append("\n");
    }

    private static int getHeuristic(String data) {
        // 목표노드 인덱스 위치의 숫자 값이 동일한지 확인 (h(n)은 작을 수록 좋은 것)
        // 휴리스틱 방법 Manhattan Distance로 해도 상관없음
        int cnt = 0;
        for (int i = 0; i < data.length(); i++) {
            if(data.charAt(i) == '#') continue;
            else if (goalNode.charAt(i) != data.charAt(i)) cnt++; //같은 위치에 같은 숫자가 아니라면 cnt++
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


    static class Puzzle implements Comparable<Puzzle>{
        String node;
        int f; //f(n)
        int g; //g(n)
        int h; //h(n)

        @Override
        public int compareTo(Puzzle o) {
            if(f == o.f) return Integer.compare(g, o.g); //f(n)이 동일하다면 이동 횟수가 작은 수 선택
            return Integer.compare(f, o.f); //f(n)기준으로 작은 수 선택
        }

        public Puzzle(String node, int f, int g, int h) {
            this.node = node;
            this.f = f;
            this.g = g;
            this.h = h;
        }
    }
}
