import java.util.*;

public class BaseBall {
    private List<Integer> answer;

    private boolean gameSet = false;


    public BaseBall() {
        Drawer drawer = new Drawer();
        answer = drawer.drawAnswer();
    }

    public String check(List<Integer> inputs) {
        if(answer.size() != inputs.size()) {
            return "Input Error";
        }

        int ball = 0;
        int out = 0;
        int strike = 0;
        for(int i = 0; i < inputs.size(); ++i) {
            if (inputs.get(i).equals(answer.get(i))) {
                strike += 1;
            } else if (answer.contains(inputs.get(i))) {
                ball += 1;
            } else {
                out += 1;
            }
        }

        if (inputs.size() == strike) {
            gameSet = true;
        }

        return String.format("Strike: %d, Ball: %d, Out: %d", strike, ball, out);
    }

    public void play() {
        Prompt prompt = new Prompt();
        while(isGameSet()) {
            List<Integer> inputs = prompt.getInputs();
            System.out.println(check(inputs));
        }
    }

    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();
        baseBall.play();
    }

    public boolean isGameSet() {
        return gameSet == false;
    }
}
