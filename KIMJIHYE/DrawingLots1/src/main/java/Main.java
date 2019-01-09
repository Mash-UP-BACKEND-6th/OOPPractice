public class Main {
    public static void main(String[] args) {
        Lot lot;
        Prompt p = new Prompt();

        while(true){
            lot = p.initPrompt(); // 제비 설정 입력받는 프롬프트
            p.showLots(lot,false);

            while(p.shufflePrompt()){
                lot.shuffle(); // 제비 섞기
                p.showLots(lot,false);
            }

            if(p.isReset)
                continue;

            p.selectPrompt(lot);

            if(p.exitPrompt())
                continue;
            else
                break;
        }

    }
}
