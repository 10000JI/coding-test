package section7;

//부분집합 구하기(DFS)
public class ExampleSix {
    //집합의 원소의 개수
    static int n;
    //체크배열: 부분집합 사용 여부 체크
    static int[] ch;

    public void DFS(int L) {
        //if는 종착점
        if (L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if(ch[i] == 1) tmp += (i + " ");
            }
            if (tmp.length() > 0) System.out.println(tmp);
        } else {
            //사용 = 1
            ch[L] = 1;
            //왼쪽으로 뻗기
            DFS(L + 1);

            //사용 X = 0
            ch[L] = 0;
            //오른쪽으로 뻗기
            DFS(L + 1);
        }

    }

    public static void main(String[] args) {
        ExampleSix T = new ExampleSix();
        n = 4;
        ch = new int[n + 1];
        T.DFS(1);
    }
}
