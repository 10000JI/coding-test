package didim365;

import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CustomProcedurePuzzle_8_Success_2 {
    // 입출력을 위한 BufferedReader와 BufferedWriter 선언
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String startNode; // 시작 노드 상태를 저장
    static String goalNode;  // 목표 노드 상태를 저장

    // 상하좌우 이동을 위한 배열
    static int[] moveRow = {-1, 0, 1, 0};
    static int[] moveCol = {0, 1, 0, -1};

    // 방문한 노드를 저장하고 중복 방문을 방지하기 위한 HashMap
    static HashMap<String, Integer> visitMap = new HashMap<>();

    // A* 알고리즘에서 우선순위를 결정하기 위한 PriorityQueue
    static PriorityQueue<Puzzle> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        // 목표 노드 입력 받기
        System.out.println("아래에 목표 노드를 3x3 형태로 입력해주세요. (빈 퍼즐은 숫자 대신 #을 입력해주세요)");
        goalNode = readBoard();

        // 시작 노드 입력 받기
        System.out.println("아래에 시작 노드를 3x3 형태로 입력해주세요. (빈 퍼즐은 숫자 대신 #을 입력해주세요)");
        startNode = readBoard();

        // 시작 노드를 우선순위 큐에 추가 (f(n) = g(n) + h(n), 여기서 g(n)은 0)
        pq.add(new Puzzle(startNode, getHeuristic(startNode), 0, getHeuristic(startNode)));
        // 시작 노드를 방문 맵에 추가
        visitMap.put(startNode, 0);

        // A* 알고리즘 실행
        boolean reachedGoal = aStar();

        // 결과 출력
        if (reachedGoal) {
            bw.write(String.valueOf("최소한의 이동 횟수: "+visitMap.get(goalNode)+ "\n"));
        } else {
            bw.write("해당 시작노드는 목표노드로 이동할 수 없습니다." + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static String readBoard() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(br.readLine());
        }
        return sb.toString();
    }

    private static boolean aStar() throws IOException {
        StringBuilder stepsLog = new StringBuilder(); // 성공 시 출력할 로그를 저장
        stepsLog.append("\n");

        while (!pq.isEmpty()) {
            Puzzle currentPuzzle = pq.poll(); // 우선순위 큐에서 가장 유망한 노드 추출
            String currentData = currentPuzzle.node;
            int currentStep = currentPuzzle.g; // 현재 노드까지의 이동 횟수

            if (currentData.equals(goalNode)) {
                // 목표 노드에 도달했을 때 로그 추가 및 출력
                consoleLog(stepsLog, currentPuzzle, goalNode);
                stepsLog.append("\n");
                bw.write(stepsLog.toString());
                bw.write("목표 상태에 도달했습니다!\n");
                return true;
            }

            // 현재 노드 상태 로그에 추가
            consoleLog(stepsLog, currentPuzzle, currentData);

            // 빈 칸(#)의 위치 찾기
            int emptyPlaceIndex = currentData.indexOf("#");
            int currentRow = emptyPlaceIndex / 3;
            int currentCol = emptyPlaceIndex % 3;

            // 상하좌우 이동 시도
            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + moveRow[i];
                int newCol = currentCol + moveCol[i];
                if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                    // 새로운 상태 생성
                    int currentPos = currentRow * 3 + currentCol;
                    int newPos = newRow * 3 + newCol;
                    String data = swap(currentData, currentPos, newPos);

                    // 이미 방문한 상태라면 건너뛰기
                    if(visitMap.containsKey(data)) continue;
                    else {
                        int g = currentStep + 1; // 이동 횟수 증가
                        int h = getHeuristic(data); // 휴리스틱 값 계산
                        int f = g + h; // f(n) = g(n) + h(n)
                        pq.add(new Puzzle(data, f, g, h)); // 우선순위 큐에 새 상태 추가
                        visitMap.put(data, g); // 방문 맵에 새 상태 추가
                    }
                }
            }
        }
        return false; // 목표 상태에 도달하지 못함
    }

    // 로그 출력을 위한 메소드
    private static void consoleLog(StringBuilder stringBuilder, Puzzle currentPuzzle, String data) {
        // 현재 상태의 f(n), g(n), h(n) 값과 이동 횟수, 퍼즐 상태를 로그에 추가
        stringBuilder.append("(1) f(n): " + currentPuzzle.f+", g(n): " + currentPuzzle.g+", h(n): " + currentPuzzle.h).append("\n");
        stringBuilder.append("(2) 이동 횟수: " + currentPuzzle.g).append("\n");
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(data.substring(i * 3, i * 3 + 3)).append("\n");
        }
        stringBuilder.append("---------").append("\n");
    }

    // 휴리스틱 함수: 맨하튼 거리로 풀이
    // 맨하튼 거리 = 차원 평면 공간에서 두 점 p 와 q 사이의 거리를 측정하는 방법, 두 점 사이의 수평 및 수직 이동 거리의 합
    // 맨허튼 거리 = ∣p1−q1∣+∣p2−q2∣
    private static int getHeuristic(String data) {
        int totalDistance = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) != '#') {
                int currentRow = i / 3;
                int currentCol = i % 3;
                int targetIndex = goalNode.indexOf(data.charAt(i));
                int targetRow = targetIndex / 3;
                int targetCol = targetIndex % 3;
                totalDistance += Math.abs(currentRow - targetRow) + Math.abs(currentCol - targetCol);
            }
        }
        return totalDistance;
    }

    // 두 타일의 위치를 교환하는 메소드
    private static String swap(String currentData, int pos1, int pos2) {
        // 현재 위치와 새 위치의 타일을 교환
        char[] chars = currentData.toCharArray();
        char temp = chars[pos1];
        chars[pos1] = chars[pos2];
        chars[pos2] = temp;
        return new String(chars);
    }

    // Puzzle 클래스: 각 상태를 나타내는 클래스
    static class Puzzle implements Comparable<Puzzle>{
        String node; // 퍼즐 상태
        int f; // f(n) = g(n) + h(n)
        int g; // 시작 노드부터 현재 노드까지의 이동 횟수
        int h; // 휴리스틱 값

        // 우선순위 큐에서 정렬 기준을 정의하는 메소드
        @Override
        public int compareTo(Puzzle o) {
            if(f == o.f) return Integer.compare(g, o.g); // f(n)이 같으면 g(n)이 작은 것을 선택
            return Integer.compare(f, o.f); // f(n)이 작은 것을 선택
        }

        // 생성자
        public Puzzle(String node, int f, int g, int h) {
            this.node = node;
            this.f = f;
            this.g = g;
            this.h = h;
        }
    }
}