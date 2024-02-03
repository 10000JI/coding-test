package section7;

//이진트리 순회(깊이우선탐색)

import java.util.LinkedList;
import java.util.Queue;

class Node2{
    int data;
    //인스턴스 변수 lt, rt는 Node라는 객체 주소를 저장
    Node2 lt, rt;

    public Node2(int val) {
        data = val;
        lt = rt = null;
    }
}

public class ExampleSeven {
    Node2 root;

    // 들어온 매개변수 root는 100번지
    public void BFS(Node2 root) {
        Queue<Node2> Q = new LinkedList<>();
        Q.offer(root);
        //L : 레벨
        int L = 0;
        while (!Q.isEmpty()) {
            //해당 레벨의 Q의 사이즈
            int len = Q.size();
            System.out.print(L+ " : " );
            for (int i = 0; i < len; i++) {
                //Q에 가장 먼저 추가된 Node2부터 cur이라는 변수에 대입 후 삭제
                Node2 cur = Q.poll();
                System.out.print(cur.data + " ");
                //상위노드의 lt가 존재하면 Q에 추가
                if(cur.lt!=null) Q.offer(cur.lt);
                //상위노드의 rt가 존재하면 Q에 추가
                if(cur.rt!=null) Q.offer(cur.rt);
            }
            //다음 레벨 +1
            L++;
            System.out.println();
        }
    }

    public static void main(String args[]) {
        ExampleSeven T = new ExampleSeven();
        //객체가 생성되는 순간 rt와 lt의 주소값은 null, data는 생성자의 매개변수로 인해 1로 세팅됨
        T.root = new Node2(1);
        //root객체의 lt의 주소값이 생기면서, 주소를 가르치는 객체의 data는 2로 세팅
        T.root.lt = new Node2(2);
        //root객체의 rt의 주소값이 생기면서, 주소를 가르치는 객체의 data는 4로 세팅
        T.root.rt = new Node2(4);
        //.. 꼬리를 물며 반복, 이때부터 생성되는 객체의 주소값은 null
        T.root.lt.lt = new Node2(4);
        T.root.lt.rt = new Node2(5);
        T.root.rt.lt = new Node2(6);
        T.root.rt.rt = new Node2(7);
        //T.root는 그림과 같은 100번지 주소
        T.BFS(T.root);
    }
}
