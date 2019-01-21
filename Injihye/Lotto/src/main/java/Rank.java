public class Rank {
    AutoNum autoNum;
    SelfNum selfNum;
    LottoNum lottoNum;
    int count = 0;

    public Rank() {  }

    public Rank(int i) {
        if (i == 1) {
            autoCompare();
            getRank();
        } else if (i == 2) {
            selfCompare();
            getRank();
        }
    }

    private void autoCompare() {
        autoNum = new AutoNum();
        int num1[] = autoNum.number;
        lottoNum = new LottoNum();
        int numLotto[] = lottoNum.number;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(num1[i] == numLotto[j])
                    count++;
            }
        }
        System.out.println("겹치는 개수는 " + count);
    }

    private void selfCompare() {
        selfNum = new SelfNum();
        int num2[] = selfNum.number;
        lottoNum = new LottoNum();
        int numLotto[] = lottoNum.number;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(num2[i] == numLotto[j])
                    count++;
            }
        }
        System.out.println("겹치는 개수는 " + count);
    }

    private void getRank() {
        if(count == 6)
            System.out.println("당첨! 1등입니다.");
        else if(count == 5)
            System.out.println("당첨! 2등입니다.");
        else if(count == 4)
            System.out.println("당첨! 3등입니다.");
        else if(count == 3)
            System.out.println("당첨! 4등입니다.");
        else
            System.out.println("당첨되지 않았습니다.");
    }

}
