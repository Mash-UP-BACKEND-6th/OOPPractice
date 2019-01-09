public class Main {
    public static void main(String[] args) {
        Lot lot = new Lot();
        Prompt p = new Prompt(lot);

        while(true){
            p.initPrompt(); // 제비 설정 입력받는 프롬프트
            lot.prepare(); // 입력받은 설정을 기준으로 제비 준비
            while(p.shufflePrompt()){
                lot.shuffle(); // 제비 섞기
            }

            if(p.isAgain)
                continue;

            p.selectPrompt();

            if(p.isAgain)
                continue;
        }

    }
}
