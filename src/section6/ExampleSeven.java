package section6;

import java.util.*;

//Comparable의 구현 클래스
class Point implements Comparable<Point> {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) return this.y - o.y; //x값이 같을 땐 y값에 의해 정렬 (음수: 작은 것을 반환, 오름차순 / 양수: 내림차순)
        else return this.x - o.x; //x값에 의해 정렬 (음수: 작은 것을 반환, 오름차순 / 양수: 내림차순)
    }
}


//좌표 정렬
public class ExampleSeven {

    public static void main(String[] args) {
        ExampleSeven T = new ExampleSeven();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            list.add(new Point(x, y));
        }
        //정렬 -> Comparable의 인터페이스를 통해서 Point 객체를 정렬, 이때 정렬의 기준이 compareTo() 메서드
        Collections.sort(list);
        for (Point o : list) {
            System.out.println(o.x+" "+o.y);
        }

    }
}
