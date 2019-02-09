public class AnyPow {
    public void play() {
        Tile tile = new Tile(getInput());
        System.out.println(tile);
        while(tile.pow()) {
            System.out.println(tile);
            tile.shift();
            System.out.println(tile);
        }
        System.out.println("Finsish!");
        System.out.println(tile);
    }

    public static void main(String[] args) {
        new AnyPow().play();

    }

    public static int[][] getInput() {
        return new int[][]{
                {1,2,3,4,1},
                {1,2,1,4,3},
                {1,2,1,2,3},
                {1,3,3,3,3},
                {1,2,1,4,3},
        };
    }
}
