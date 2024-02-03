package section7;

import java.util.LinkedList;
import java.util.Queue;

//Tree 말단 노드까지의 가장 짧은 경로 - BFS
class Node4 {
    int data;
    Node4 lt, rt;

    Node4(int val) {
        data = val;
        lt = rt = null;
    }
}


public class ExampleTen {
    Node4 root;

    public int BFS(Node4 root) {
        Queue<Node4> Q = new LinkedList<>();
        //이진트리의 상위 노드 값 Queue에 저장
        Q.offer(root);
        //레벨 0 설정
        int L = 0;
        //Queue가 비어있지 않다면
        while (!Q.isEmpty()) {
            //Queue의 size를 len에 대입 후
            int len = Q.size();
            //len 길이만큼 for문이 돌아감
            for (int i = 0; i < len; i++) {
                //Queue에 넣었던 노드 값을 cur에 대입하면서 Queue에서 삭제
                Node4 cur = Q.poll();
                //cur의 lt(왼쪽)에 위치한 노드가 null, cur의 lt(오른쪽)에 위치한 노드가 null 이라면 레벨 리턴 후 출력
                if (cur.lt == null && cur.rt == null) return L;
                // cur의 lt(왼쪽)에 위치한 노드가 null이 아니라면 Queue에 해당 노드 저장
                if (cur.lt != null) Q.offer(cur.lt);
                // cur의 lt(오른쪽)에 위치한 노드가 null이 아니라면 Queue에 해당 노드 저장
                if (cur.rt != null) Q.offer(cur.rt);
            }
            //레벨+1
            L++;
        }
        //실제로 여기까진 오지 않지만 에러가 발생하므로, while문이 돌지 않았을 때를 가정하여 0으로 리턴
        return 0;
    }

    public static void main(String[] args) {
        ExampleTen T = new ExampleTen();
        T.root = new Node4(1);
        T.root.lt = new Node4(2);
        T.root.rt = new Node4(4);
        T.root.lt.lt = new Node4(4);
        T.root.lt.rt = new Node4(5);
        //0번 레벨과, 이진트리의 맨 위에 있는 root(Node4 객체 통째로 넣기 때문에 주소값)를 매개변수로 넣음
        System.out.println(T.BFS(T.root));
    }
}
