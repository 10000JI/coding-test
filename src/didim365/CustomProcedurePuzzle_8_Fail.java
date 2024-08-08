package didim365;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CustomProcedurePuzzle_8_Fail {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String goalBoard;
    static char[][] board;
    static int[] moveRow = {-1, 0, 1, 0};
    static int[] moveCol = {0, 1, 0, -1};
    static HashMap<Integer, Integer> visitMap = new HashMap<>(); //한 번의 테스트 시 방문 여부 체크: 순서X 중복(키X,값O)
    static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.f == o2.f) return Integer.compare(o1.g, o2.g); //f(n)이 동일하다면 이동회수가 더 적은 노드가 우선순위
            return Integer.compare(o1.f, o2.f); //f(n)기준으로 작은 수 선택
        }
    });

    public static void main(String[] args) throws IOException {
        System.out.println("아래에 목표 노드를 3x3 형태로 입력해주세요 (빈 퍼즐은 숫자 대신 #을 입력해주세요)");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(br.readLine());
        }
        goalBoard = sb.toString().replace('#', '9');
        System.out.println("아래에 시작 노드를 3x3 형태로 입력해주세요");
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
        int step = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            String currentData = currentNode.data;

            StringBuilder sb = new StringBuilder();
            sb.append("step: " + step++).append("\n");
            for (int i = 0; i < 3; i++) {
                sb.append(currentData.substring(i * 3, i * 3 + 3)).append("\n");
            }
            sb.append("---------").append("\n");
            bw.write(sb.toString());
            bw.flush();

            int emptyPlaceIndex = currentData.indexOf("9");
            int currentRow = emptyPlaceIndex / 3;
            int currentCol = emptyPlaceIndex % 3;

            if (currentData.equals(goalBoard)) {
                bw.write("목표 상태에 도달했습니다!\n");
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + moveRow[i];
                int newCol = currentCol + moveCol[i];
                if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                    StringBuilder nextData = new StringBuilder(currentData);
                    nextData = swap(currentRow, currentCol, newRow, newCol, nextData);
                    String data = nextData.toString();

                    if(visitMap.containsKey(Integer.parseInt(data))) continue;
                    else {
                        int g = currentNode.g + 1;
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

    private static int getHeuristic(String data) {
        // 목표노드 인덱스 위치의 숫자 값이 동일한지 확인 (h(n)은 작을 수록 좋은 것)
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

    static class Node {
        String data;
        int g; //g(n)
        int f; //f(n)

        public Node(String data, int g, int f) {
            this.data = data;
            this.g = g;
            this.f = f;
        }
    }
}
