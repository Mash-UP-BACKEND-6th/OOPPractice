import java.util.List;

public class Machine {
    int myRank = 0;
    Lotto lotto = new Lotto();

    public void check(Lotto myLotto) {
        List<Integer> numbers = myLotto.numbers;
        List<Integer> myNumbers = lotto.numbers;
        int count = 0;

        for (int j = 0; j < numbers.size(); j++) {
            for (int i = 0; i < myNumbers.size(); i++) {
                if (numbers.get(j) == myNumbers.get(i)) {
                    count++;
                }
            }
        }

        switch (count) {
            case 6:
                myRank = 1;
                break;
            case 5:
                for (int i = 0; i < myNumbers.size(); i++) {
                    if (myNumbers.get(i) == numbers.get(6)) {
                        myRank = 2;
                        break;
                    } else {
                        myRank = 3;
                    }
                }
                break;
            case 4:
                myRank = 4;
                break;
            case 3:
                myRank = 5;
                break;
            default:
                myRank = 9999;
        }
    }

    public void print(){
        if(myRank==9999){
            System.out.println("꽝. 등수에 없음.");
        }else{
            System.out.println("축! "+myRank+"등 입니다 :)");
        }

        System.out.println("로또 당첨 번호");
        System.out.println(lotto.numbers);
    }
}
