package didim365;

import java.io.*;
import java.util.*;

public class Puzzle_8_11112 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] board;
    static int[] moveRow = {-1, 0, 1, 0};
    static int[] moveCol = {0, 1, 0, -1};
    static HashMap<Integer, Integer> visitMap = new HashMap<>(); //한 번의 테스트 시 방문 여부 체크: 순서X 중복(키X,값O)
    static HashSet<Integer> impossibleSet = new HashSet<Integer>(); //메모이제이션(2번 이상의 테스트 케이스 시 필요)
    static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.f == o2.f) return Integer.compare(o1.g, o2.g); //f(n)이 동일하다면 이동회수가 더 적은 노드가 우선순위
            return Integer.compare(o1.f, o2.f); //f(n)기준으로 작은 수 선택
        }
    });

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < x; i++) {
            br.readLine(); // 빈라인
            insert(); //입력
            aStar(); //a* 알고리즘
            if (visitMap.containsKey(Integer.parseInt("123456789"))) {
                bw.write(String.valueOf(visitMap.get(Integer.parseInt("123456789")) + "\n"));
            } else { //불가능한 케이스라면, 지나온 과정 모든 것이 불가능한 결과로 가는 과정이므로 메모이제이션
                for(Integer key : visitMap.keySet()) impossibleSet.add(key);
                bw.write("impossible" + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
     
    private static void aStar(){
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            String currentData = currentNode.data;
            int emptyPlaceIndex = currentData.indexOf("9"); // 빈공간 위치 인덱스
            int currentRow = emptyPlaceIndex / 3;
            int currentCol = emptyPlaceIndex % 3;

            //테스트 케이스 중 impossible이 나온 적이 있다면 메모이제이션에 추가해놓음
            if(impossibleSet.contains(Integer.parseInt(currentData))) return;

            String data = "";
            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + moveRow[i];
                int newCol = currentCol + moveCol[i];
                if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                    StringBuilder nextData = new StringBuilder(currentData);
                    nextData = swap(currentRow, currentCol, newRow, newCol, nextData);
                    data = nextData.toString();

                    if(visitMap.containsKey(Integer.parseInt(data))) continue; //이미 봤던 케이스라면 건너뛴다.
                    else{
                        /** f(n) = g(n) + h(n) **/
                        //g(n): 현재까지의 값, 지금까지 움직인 횟수
                        //h(n): 제자리에 있지 않은 퍼즐 수
                        int g = currentNode.g;
                        int h = getHeuristic(data);
                        int f = g + h;
                        pq.add(new Node(data, g+1, f));
                        visitMap.put(Integer.parseInt(data), g + 1);
                    }
                }
            }
            if(visitMap.containsKey(Integer.parseInt("123456789"))) return;
        }
    }

    private static int getHeuristic(String data) {
        // 목표노드 인덱스 위치의 숫자 값이 동일한지 확인 (h(n)은 작을 수록 좋은 것)
        int cnt = 0;
        for (int i = 0; i < data.length(); i++) {
            if ("123456789".charAt(i) != data.charAt(i)) cnt++; //같은 위치에 같은 숫자가 아니라면 cnt++
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
        visitMap.clear(); //여러번의 테스트 케이스가 들어오기 때문에 초기화 진행
        pq.clear(); //이하동문
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
