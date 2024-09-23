import java.util.Stack;

public class Grid {
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];

    /**
     * Flood fill, starting with the given row and column.
     */
    public void floodfill(int row, int column) {
        Stack<Pair> stack = new Stack<>();
        int counter = 1;
        stack.push(new Pair(row, column));

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            int r = p.row;
            int c = p.column;

            if (pixels[r][c] == 0) {
                pixels[r][c] = counter++;

                // Push neighbors in order: North, East, South, West
                // North
                if (r - 1 >= 0 && pixels[r - 1][c] == 0) {
                    stack.push(new Pair(r - 1, c));
                }
                // East
                if (c + 1 < SIZE && pixels[r][c + 1] == 0) {
                    stack.push(new Pair(r, c + 1));
                }
                // South
                if (r + 1 < SIZE && pixels[r + 1][c] == 0) {
                    stack.push(new Pair(r + 1, c));
                }
                // West
                if (c - 1 >= 0 && pixels[r][c - 1] == 0) {
                    stack.push(new Pair(r, c - 1));
                }
            }
        }
    }

    @Override
    public String toString() {
        String r = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
