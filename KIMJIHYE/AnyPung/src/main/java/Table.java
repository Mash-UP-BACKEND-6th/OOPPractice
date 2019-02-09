import java.util.ArrayList;
import java.util.Random;

public class Table {
    public int size = 0;
    public ArrayList<String> patterns;

    public Table(int size){
        this.size = size;
        init();
    }

    // 사용자로부터 패턴으로 이용할 문자 배열 하나 받는 다거나
    // 판때기의 숫자 모두를 입력 받는 다거나 구현
    /*public Table(int size, char[] c){

    }*/

    private void init(){
        Random random = new Random();
        patterns = new ArrayList<String>();
        char[] c = new char[size];
        for(int j=0;j<size; j++){
            for(int i=0; i<size;i++){
                c[i] = Character.forDigit(random.nextInt(4)+1,10);
            }
            patterns.add(new String(c));
        }

    }

    public void print(){
        for(String line : patterns){
            for(char c : line.toCharArray()){
                // 보기 좋게 숫자 사이에 빈칸 넣어주기
                if(c-0 == 0){
                    System.out.print('0'+"  ");
                }else{
                    System.out.print(c+"  ");
                }
            }
            System.out.println();
        }
    }


}
