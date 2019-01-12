import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Set<Character> charSet= new HashSet<Character>();
        String rand;
        int randSize;

        do{
            charSet.clear();
            rand = String.valueOf(random.nextInt(9900)+100);
            randSize = rand.length();

            for(int i=0;i<randSize;i++){
                charSet.add(rand.charAt(i));
            }

            // 중복숫자 발생시 다시 랜덤 숫자 생성
        }while(charSet.size() != rand.length());

        System.out.println("숫자 야구 게임");

        while(true){
            int ball = 0;
            int strike = 0;

            System.out.print("예상되는 숫자를 입력("+randSize+"자리 숫자): ");
            String input = scanner.next();

            if(randSize != input.length()){
                System.out.println(randSize+"자리 숫자를 입력하세요");
                continue;
            }

            for(int i=0; i<randSize; i++){
                Character ch = input.charAt(i);
                // strike 개수 체크
                if(ch == rand.charAt(i))
                    strike ++;
                // ball 개수 체크
                if(charSet.contains(ch))
                    ball++;
            }
            // ball 에 strike개수가 중복되어 세졌으니까 빼준다.
            ball = ball-strike;

            if(strike == randSize){
                System.out.println(strike+"S "+ball+"B");
                System.out.println("게임 종료");
                break;
            }else if(strike == 0 && ball ==0){
                System.out.println("아웃");
            }else{
                System.out.println(strike+"S "+ball+"B");
            }

        }

    }


}
