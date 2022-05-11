import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.security.auth.Subject;

abstract class MapGenerator {
    private static Symbol[][] grid;

    static class Symbol{
        int row, col;
        boolean isOpen;
        Symbol n;
        Symbol ne;
        Symbol e;
        Symbol se;
        Symbol s;
        Symbol sw;
        Symbol w;
        Symbol nw;

        Symbol(int row, int col, boolean isOpen) {
            this.row = row;
            this.col = col;
            this.isOpen = isOpen;
        }
    }

    static void generate(String path, int number, int rows, int columns) {
        try {
            for (int i = 0; i < number; i++) {
                File map = new File(path + "/map" + i);
                FileWriter fileWriter = new FileWriter(map);
                grid = generateRandomMap(rows, columns);
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static private Symbol[][] generateRandomMap(int rows, int columns) {
        Symbol[][] grid = new Symbol[rows][columns];

        // set map borders
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (row == 0 || row == rows - 1 || col == 0 || col == columns - 1) grid[row][col] = new Symbol(row, col, false); 
            }
        }

        // generate path
        grid = generatePath(grid);

        return grid;
    }

    static Symbol[][] generatePath(Symbol[][] grid) {
        Symbol[][] new_grid = grid;


        return new_grid;
    }
}
