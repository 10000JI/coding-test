package section7;

//이진트리 순회(깊이우선탐색)

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
    }

    public static void main(String args[]) {
        ExampleSeven T = new ExampleSeven();
        //객체가 생성되는 순간 rt와 lt의 주소값은 null, data는 생성자의 매개변수로 인해 1로 세팅됨
        T.root = new Node2(1);
        //root객체의 lt의 주소값이 생기면서, 주소를 가르치는 객체의 data는 2로 세팅
        T.root.lt = new Node2(2);
        //root객체의 rt의 주소값이 생기면서, 주소를 가르치는 객체의 data는 3로 세팅
        T.root.rt = new Node2(3);
        //.. 꼬리를 물며 반복, 이때부터 생성되는 객체의 주소값은 null
        T.root.lt.lt = new Node2(4);
        T.root.lt.rt = new Node2(5);
        T.root.rt.lt = new Node2(6);
        T.root.rt.rt = new Node2(7);
        //T.root는 그림과 같은 100번지 주소
        T.BFS(T.root);
    }
}
