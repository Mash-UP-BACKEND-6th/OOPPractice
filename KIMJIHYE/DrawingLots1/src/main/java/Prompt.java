import java.util.Scanner;

class Prompt {
    boolean isReset=false;
    Scanner scanner = new Scanner(System.in);

    Lot initPrompt(){
        System.out.println("+-------------제비뽑기");
        System.out.print("| 인원 수 : ");
        int lotsNum = scanner.nextInt();

        System.out.print("| 꽝 개수 : ");
        int losingNum = scanner.nextInt();
        System.out.println("+---------------------");

        Lot lot = new Lot(lotsNum, losingNum);

        System.out.println();
        isReset = false; // 초기설정으로 돌아가기로 온경우 true상태이므로 다시 초기화
        scanner.nextLine(); // 뒤에서 엔터입력 받기위해 비워주기

        return lot;
    }

    boolean shufflePrompt(){
        System.out.print("제비를 다시 섞을까요(y or n) ? (초기설정으로 돌아가기 q) ");

        switch(scanner.next()){
            case "Y":
            case "y":
                return true;
            case "N":
            case "n":
                return false;
            case "q":
                isReset = true;
                return false;
            default:
                System.out.println("잘못된 입력!");
                return true;
        }
    }

    void selectPrompt(Lot lot){
        System.out.print("제비를 선택하세요 : ");
        Integer selectedLot =Integer.parseInt(scanner.next());
        System.out.println("==> 결과 : "+ lot.getResult(selectedLot));
        scanner.nextLine(); // 아래에서 Enter입력 받기 위해 비워주기
        System.out.println("+--------------------------------------------------+");
        System.out.println("| Enter를 누르면 전체 결과가 출력됩니다.           |");
        System.out.println("+--------------------------------------------------+");
        scanner.nextLine();
        showLots(lot,true);
    }

    void showLots(Lot lot, boolean answer){

        for(int i=0;i<lot.lotsNum;i++){
            System.out.print("+-----+    ");
        }
        System.out.println();

        // 제비 번호 출력
        for(int i=1;i<=lot.lotsNum;i++){
                System.out.print("|  "+i+"  |    ");
        }

        // 꽝, 통과 출력
        System.out.println();
        for(int i=1;i<=lot.lotsNum;i++){
            if(answer){
                System.out.print("|"+lot.getResult(i)+"|    ");
            }else{
                System.out.print("|     |    ");
            }
        }

        System.out.println();
        for(int i=0;i<lot.lotsNum;i++){
            System.out.print("+-----+    ");
        }
        System.out.println();
    }

    boolean exitPrompt(){
        while(true){
            System.out.println("계속하시겠습니까? (계속하려면 y, 종료하려면 q)");
            switch(scanner.next()) {
                case "y":
                case "Y":
                    return true;
                case "q":
                case "Q":
                    System.out.println("제비뽑기를 종료합니다.");
                    return false;
                default:
                    System.out.println("잘못된 입력!");
            }
        }

    }

}
