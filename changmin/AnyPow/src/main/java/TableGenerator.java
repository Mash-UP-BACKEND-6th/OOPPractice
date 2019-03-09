public class TileGenerator {
    public int[][] get() {
        return new int[][]{
                {1,2,3,4,1},
                {1,2,1,4,3},
                {1,2,1,2,3},
                {1,3,3,3,3},
                {1,2,1,4,3},
        };
    }

    public Table generate() {
        return new Table(get());
    }
}
