package calendar;

/**
 * Created by changmin on 2018. 12. 15..
 */
public class Liner {
    /*
        IO는 비용이 크므로 1번만 호출
        싱글 스레드 프로그램이므로 StringBuilder를 이용 String을 생성한다.
        컴파일시 StringBuilder를 생성하지만, 명시적으로 하는게 더 좋다고 판단
    */
    public void print(int n) {
        //
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            stb.append("-");
        }

        System.out.println(stb);
    }
}
