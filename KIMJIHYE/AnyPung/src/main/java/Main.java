import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*System.out.println("게임판 크기 설정(ex. 5) : ");
        int size = scanner.nextInt();
        Table tb = new Table(size);*/
        Table tb = new Table(5); // 5 X 5 격자의 게임판
        Pung pung = new Pung(tb);
        int round = 0;

        System.out.println("애니펑 시작!");
        // check를 통해 없앨 부분이 있나 체크(연속되는 부분이 있나)
        while(pung.check()){
            round ++;
            System.out.println("== "+round+"회 ==");
            tb.print();
            pung.test(); // 출력
            System.out.println(" 펑 !! ");
            pung.pung();
            tb.print();
            pung.arrange();
            System.out.println("--- 정렬 ---");
            tb.print();
        }
        System.out.println("펑 끝.");
        tb.print();
        System.out.println("애니펑 종료.");
    }


}
