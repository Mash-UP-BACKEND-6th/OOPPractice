package main;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        Generator generator = new Generator();
        Lotto lotto = new Lotto();

        int random[] = generator.Random();
        int bonus = generator.bonus();
        int my[] = user.User();
        int myBonus = user.Bonus();

        int correct = lotto.comare(random, my);
        int bonusCheck = lotto.bonusCheck(bonus, myBonus);

        lotto.result(correct, bonusCheck);
    }
}
