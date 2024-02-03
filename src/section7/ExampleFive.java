package section7;

class Node{
    int data;
    //인스턴스 변수 lt, rt는 Node라는 객체 주소를 저장
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

//이진트리 순회(깊이우선탐색)
public class ExampleFive {
    Node root;

    // 들어온 매개변수 root는 100번지
    public void DFS(Node root) {
        //root가 null이면 말단 노드로 온 것
        if(root==null) return;
        else {
            //root 노드에서는 lt와 rt 모두 뻗어 가야됨
            /**
             * 후위순회
             */
            //(1) lt 먼저 수행한 후 (root.lt.lt->root.lt.rt, 여기서 root.lt는 매개변수 root로 다시 받음)
            //(2) 모든 로직이 돌면 rt 수행 (root.rt.lt->root.rt.rt, 여기서 root.rt는 매개변수 root로 다시 받음)
            DFS(root.lt);
            DFS(root.rt);
            System.out.print(root.data+" ");
        }
    }

    public static void main(String args[]) {
        ExampleFive T = new ExampleFive();
        //객체가 생성되는 순간 rt와 lt의 주소값은 null, data는 생성자의 매개변수로 인해 1로 세팅됨
        T.root = new Node(1);
        //root객체의 lt의 주소값이 생기면서, 주소를 가르치는 객체의 data는 2로 세팅
        T.root.lt = new Node(2);
        //root객체의 rt의 주소값이 생기면서, 주소를 가르치는 객체의 data는 4로 세팅
        T.root.rt = new Node(4);
        //.. 꼬리를 물며 반복, 이때부터 생성되는 객체의 주소값은 null
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        T.root.rt.lt = new Node(6);
        T.root.rt.rt = new Node(7);
        //T.root는 그림과 같은 100번지 주소
        T.DFS(T.root);
    }
}
