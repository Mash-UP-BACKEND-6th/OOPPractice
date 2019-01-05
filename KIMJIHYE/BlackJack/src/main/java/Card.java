
public class Card {
    int number;
    String shape;
    int value;

    public Card(int number, int shape){
        this.number = number;
        switch(shape){
            case 1 :
                this.shape = "Diamond";
                break;
            case 2 :
                this.shape = "Heart";
                break;
            case 3 :
                this.shape = "Spade";
                break;
            case 4:
                this.shape = "Clova";
                break;
        }

        switch(number) {
            case 1:
                this.value = 1;
            case 11:
            case 12:
            case 13:
                this.value = 10;
            default:
                this.value = number;
        }
    }

    int getNumber(){
        return number;
    }

    public String getShape(){
        return shape;
    }
}
