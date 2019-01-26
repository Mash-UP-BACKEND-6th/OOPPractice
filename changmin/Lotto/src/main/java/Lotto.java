import java.util.List;

public class Lotto {

    public static void main(String[] args) {
        Lotto lotto = new Lotto();

        Prompt prompt = new Prompt();
        List<Integer> inputs = prompt.getNumber(6);
        int bonus = prompt.getNumber(1).remove(0);

        Drawer drawer = new Drawer();
        List<Integer> draws = drawer.draw(6);
        int bonusDraw = drawer.draw();

        int matched = lotto.check(inputs, draws);

        StringBuilder stb = new StringBuilder();
        stb.append("결과는 ");
        for(int draw : draws) {
            stb.append(draw);
            stb.append(" ");
        }
        stb.append("보너스 : ");
        stb.append(bonusDraw);
        stb.append("\n");

        switch (matched) {
            case 6:
                stb.append("1등");
                break;
            case 5:
                if (bonus == bonusDraw) {
                    stb.append("2등");
                    break;
                }
                stb.append("3등");
                break;
            case 4:
                stb.append("4등");
                break;
            case 3:
                stb.append("3등");
                break;
            default:
                stb.append("꽝");
        }
        prompt.print(stb.toString());
    }

    public int check(List<Integer> inputs, List<Integer> draws) {
        int count = 0;

        for(int input : inputs) {
            for(int draw : draws) {
                if(input == draw) {
                    count++;
                }
            }
        }

        return count;
    }
}
