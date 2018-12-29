package first.version;
public class Main {
    public static void main(String[] args) {
        /// 1. 년도 입력시 해당 년도 모든 달 출력
        /// 2. 년도와 월 입력시 해당하는 한달치의 달력 출력
        /// 3. 현재 날짜부터 그해 말까지의 달력 출력

        boolean isEnd=false;

        do{
            Prompt p = new Prompt();
            isEnd = p.initPrompt();
        }while(isEnd != true);

    }
}
