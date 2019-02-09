import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tile {
    int[][] input;

    public Tile(int[][] input) {
        init(input);
    }

    public void init(int[][] input) {
        this.input = input;
    }

    public boolean pow(List<Point> list) {
        if (list.size() < 3) {
            return false;
        }
        for(Point p : list) {
            input[p.x][p.y] = 0;
        }
        return true;
    }

    public void shift() {
        for(int j = 0; j < input[0].length; ++j) {
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < input.length; ++i) {
                if (input[i][j] != 0) {
                    stack.push(input[i][j]);
                    input[i][j] = 0;
                }
            }
            int i = input.length - 1;
            while(i > 0 && !stack.empty()){
                input[i--][j] = stack.pop();
            }
        }
    }

    public void floodFill(int x, int y, List<Point> list, int target) {

        if (x < 0 || y < 0 || x >= input.length || y >= input[0].length) {
            return;
        }

        if (input[x][y] == target) {
            Point p = new Point(x, y);

            if (list.contains(p)) {
                return;
            }

            list.add(p);
            floodFill(x+1, y, list, target);
            floodFill(x, y+1, list, target);
            floodFill(x-1, y, list, target);
            floodFill(x, y-1, list, target);
        }

    }

    public boolean pow() {
        int count = 0;
        for(int i = 0; i < input.length; ++i) {
            for(int j = 0 ; j < input[0].length; ++j) {

                List<Point> list = new ArrayList<>();

                int target = input[i][j];

                if(target == 0) {
                    continue;
                }

                floodFill(i, j, list, target);
                if (pow(list)) {
                    count += 1;
                };
            }
        }
        return count > 0;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < input.length; ++i) {
            for(int j = 0 ; j < input[0].length; ++j) {
                stb.append(input[i][j]);
            }
            stb.append("\n");
        }
        return stb.toString();
    }
}
