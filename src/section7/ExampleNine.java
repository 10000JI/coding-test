package section7;

//Tree 말단 노드까지의 가장 짧은 경로
class Node3 {
    int data;

    Node3 lt, rt;

    Node3(int val) {
        data = val;
        lt = rt = null;
    }
}

public class ExampleNine {
    Node3 root;

    public int DFS(int L, Node3 root) {
        //상위노드의 lt rt 값이 null이라면(Node3 객체가 없다면 = 주소가 null이라면) 매개변수로 받은 레벨값 리턴
        if(root.lt == null && root.rt == null) return L;
        //상위노드에서 lt rt 값 중 작은 값을 리턴, 그냥 리턴이 아니라 DFS에 넣어 리턴하여 "재귀함수" 구현
        else return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
    }

    public static void main(String[] args) {
        ExampleNine T = new ExampleNine();
        T.root = new Node3(1);
        T.root.lt = new Node3(2);
        T.root.rt = new Node3(3);
        T.root.lt.lt = new Node3(4);
        T.root.lt.rt = new Node3(5);
        //0번 레벨과, 이진트리의 맨 위에 있는 root(Node3 객체 통째로 넣기 때문에 주소값)를 매개변수로 넣음
        System.out.println(T.DFS(0, T.root));
    }
}
