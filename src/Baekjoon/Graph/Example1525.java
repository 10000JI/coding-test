package Baekjoon.Graph;

import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Example1525 {
    static char[][] board;
    static int[] moveRow = {-1, 0, 1, 0};
    static int[] moveCol = {0, 1, 0, -1};
    static HashMap<Integer, Integer> visitMap = new HashMap<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        board = new char[3][3];
        String str = "";
        for (int row = 0; row < 3; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 3; col++) {
                board[row][col] = st.nextToken().charAt(0);
                str += board[row][col];
            }
        }
        pq.add(new Node(str, 0, 0));
        visitMap.put(Integer.parseInt(str), 0);
        astar();
        if (visitMap.containsKey(Integer.parseInt("123456780"))) {
            bw.write(String.valueOf(visitMap.get(Integer.parseInt("123456780"))));
        } else {
            bw.write("-1");

        }
        bw.flush();
        bw.close();
    }

    private static void astar() {
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            String currentData = currentNode.data;
            int emptyPlaceIndex = currentData.indexOf("0");
            int currentRow = emptyPlaceIndex / 3;
            int currentCol = emptyPlaceIndex % 3;

            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + moveRow[i];
                int newCol = currentCol + moveCol[i];
                if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                    StringBuilder nextData = new StringBuilder(currentData);
                    nextData = swap(currentRow, newRow, currentCol, newCol, nextData);
                    String data = nextData.toString();

                    if (visitMap.containsKey(Integer.parseInt(data))) {
                        continue;
                    } else {
                        int g = currentNode.g+1;
                        int h = getHeuristic(data);
                        int f = g + h;
                        pq.add(new Node(data, g, f));
                        visitMap.put(Integer.parseInt(data), g);
                    }
                }
            }
            if(visitMap.containsKey(Integer.parseInt("123456780"))) return;
         }
    }

    private static int getHeuristic(String data) {
        int cnt = 0;
        for (int i = 0; i < data.length(); i++) {
            if("123456780".charAt(i) != data.charAt(i)) cnt++;
        }
        return cnt;
    }

    private static StringBuilder swap(int currentRow, int newRow, int currentCol, int newCol, StringBuilder nextData) {
        int currentRC = currentRow * 3 + currentCol; //빈공간 위치 인덱스
        int newRC = newRow * 3 + newCol; //변경할 값이 있는 인덱스
        char tmp = nextData.charAt(currentRC);
        nextData.setCharAt(currentRC, nextData.charAt(newRC));
        nextData.setCharAt(newRC, tmp);
        return nextData;
    }

    static class Node implements Comparable<Node> {
        String data;
        int g;
        int f;

        @Override
        public int compareTo(Node o) {
            if (f == o.f) return Integer.compare(g, o.g);
            return Integer.compare(f, o.f);
        }

        public Node(String data, int g, int f) {
            this.data = data;
            this.g = g;
            this.f = f;
        }
    }
}
