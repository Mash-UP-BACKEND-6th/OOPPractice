import java.util.Scanner;

public class Prompt {
    Scanner sc = new Scanner(System.in);
    AutoNum autoNum;
    SelfNum selfNum;
    LottoNum lottoNum;
    Rank rank;

    int check = 0;

    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        prompt.start();

    }

    public void menu() {
        System.out.println("\n-------------------------");
        System.out.println("1. Lotto 번호 자동 부여");
        System.out.println("2. Lotto 번호 셀프 지정");
        System.out.println("3. 자동 번호 당첨 여부 확인");
        System.out.println("4. 수동 번호 당첨 여부 확인");
        System.out.println("5. 당첨 번호 확인");
        System.out.println("q. 종료");
        System.out.println("-------------------------");
    }


    private void start() {

        while(true) {
            menu();
            int cmd = Integer.parseInt(sc.nextLine());
            switch (cmd) {
                case 1:
                    autoNum(); break;
                case 2:
                    selfNum(); break;
                case 3:
                    checkWinAuto(); break;
                case 4:
                    checkWinSelf(); break;
                case 5:
                    showNumber(); break;
                default:
                    break;
            }
        }
    }


    private void autoNum() {
        autoNum = new AutoNum();
        //number.createNumber();
        autoNum.Auto();
        check = 1;

    }

    private void selfNum() {
        selfNum = new SelfNum();
        selfNum.self();
        check = 2;
    }

    private void checkWinAuto() {
        lottoNum = new LottoNum();
        lottoNum.Lotto();
        rank = new Rank(1);
    }

    private void checkWinSelf() {
        lottoNum = new LottoNum();
        lottoNum.Lotto();
        rank = new Rank(2);
    }

    private void showNumber() {
        if (check == 1) {
            autoNum.output();
        } else if (check == 2) {
            selfNum.output();
        }
        lottoNum.output();
    }
}
