public class LottoNum {
    int number[] = new int[6];
    public LottoNum() {
        input();  //로또번호생성 및 중복숫자제거
        sort();   //오름차순 및 내림차순 정렬
    }


    private void input() {
        for(int i=0; i<=5;i++){ //로또번호생성
            number[i] = (int)(Math.random()*45+1);
            for(int j=0;j<=i-1;j++){  //중복숫자제거
                if(number[i]==number[j]){
                    i--;
                }
            }
        }
    }
    private void sort() {
        int temp = 0;
        for(int i=0;i<=4;i++){
            for(int j=i+1;j<=5;j++){
                if(number[i]>number[j]){  //오름차순 및 내림차순 선택
                    temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
        }
    }

    public void output() {
        for(int i=0;i<=5;i++){
            System.out.print(number[i]+ " ");  ///출력
        }
    }

    public void Lotto() {
        new LottoNum();
    }
}
