package firstVersion;
import java.util.Scanner;

public class Prompt {
    Lot lot;
    boolean firstShuffle=false; // 최초 섞기
    boolean isAgain=false;
    Scanner scanner = new Scanner(System.in);

    public Prompt(Lot lot){
        this.lot = lot;
    }

    void initPrompt(){
        System.out.println("+-------------제비뽑기");
        System.out.print("| 인원 수 : ");
        lot.peopleN = scanner.nextInt();

        System.out.print("| 꽝 개수 : ");
        lot.losingN = scanner.nextInt();
        System.out.println("+---------------------");
        System.out.println();
        isAgain = false;
        scanner.nextLine(); // 뒤에서 엔터입력 받기위해 비워주기
    }

    boolean shufflePrompt(){
        if( firstShuffle == false) {
            System.out.println("제비가 준비되었습니다");
            showLots();
            System.out.println("Enter를 눌러 제비를 섞어주세요  :)  ");
            scanner.nextLine();
            firstShuffle=true;
            return true;
        }else {
            showLots();
            System.out.print("제비를 다시 섞을까요(y or n) ? (초기설정으로 돌아가기 q) ");
        }

        switch(scanner.next()){
            case "Y":
            case "y":
                return true;
            case "N":
            case "n":
                return false;
            case "q":
                isAgain = true;
                return false;
            default:
                System.out.println("잘못된 입력!");
                return true;
        }
    }

    void selectPrompt(){
        System.out.print("제비를 선택하세요 : ");
        String selectedLot = scanner.next();
        System.out.println("==> 결과 : "+ lot.getResult(selectedLot));
        System.out.println("+------------------------+");
        System.out.println("| 1. 전체 결과보기       |");
        System.out.println("| 2. 다시하기            |");
        System.out.println("| 3. 종료                |");
        System.out.println("+------------------------+");
        switch(scanner.nextInt()){
            case 1:
                showAllPrompt();
                break;
            case 2:
                isAgain=true;
                break;
            case 3:

                break;
        }
    }

    void showAllPrompt(){

    }

    void showLots(){
        for(int i=0;i<lot.peopleN;i++){
            System.out.print("+-----+    ");
        }
        System.out.println();
        for(int i=0;i<lot.peopleN;i++){
            System.out.print("|  "+(i+1)+"  |    ");
        }
        System.out.println();
        for(int i=0;i<lot.peopleN;i++){
            System.out.print("+-----+    ");
        }
        System.out.println();
    }

}
