package day_4;

public class Main {

    public static void main(String[] args) {
        String[] grid = {
                "MMMSXXMASM",
                "MSAMXMSMSA",
                "AMXSXMAAMM",
                "MSAMASMSMX",
                "XMASAMXAMM",
                "XXAMMXXAMA",
                "SMSMSASXSS",
                "SAXAMASAAA",
                "MAMMMXMMMM",
                "MXMXAXMASX"
        };

        int result = countXmas(grid);
        System.out.println("Total occurrences of XMAS: " + result);
    }

    public static int countXmas(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        String target = "XMAS";
        int targetLen = target.length();
        int count = 0;

        int[][] directions = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0},
                {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int[] direction : directions) {
                    if (isXmasFound(grid, r, c, direction[0], direction[1], target, rows, cols, targetLen)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean isXmasFound(String[] grid, int r, int c, int rowStep, int colStep, String target, int rows, int cols, int targetLen) {
        for (int i = 0; i < targetLen; i++) {
            int newR = r + i * rowStep;
            int newC = c + i * colStep;
            if (newR < 0 || newR >= rows || newC < 0 || newC >= cols) return false;
            if (grid[newR].charAt(newC) != target.charAt(i)) return false;
        }
        return true;
    }
}
