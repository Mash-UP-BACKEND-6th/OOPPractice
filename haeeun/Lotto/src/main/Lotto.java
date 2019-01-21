package main;

public class Lotto {

    public int comare(int lotto[], int user[]){
        int correct = 0;
        for(int i = 0; i < 6; i++){
            if (lotto[i] == user[i]){
                correct++;
            }
        }
        return correct;
    }

    public int bonusCheck(int bonus, int userBonse){
        int bonusScore = 0;
        if (bonus == userBonse){
            bonusScore++;
        }
        return bonusScore;
    }

    public void result(int correct, int bonusScore){
        int ranking;
        switch (correct) {
            case 6:
                ranking = 1;
                break;
            case 5:
                if(bonusScore > 0){
                    ranking = 2;
                } else {
                    ranking = 3;
                }
                break;
            case 4:
                ranking = 4;
                break;
            case 3:
                ranking = 5;
                break;
            default:
                ranking = 0;
                break;
        }

        if(ranking > 0){
            System.out.println(ranking + "등");
        } else {
            System.out.println("꽝");
        }
    }

}
