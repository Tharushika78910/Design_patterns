
public class PixelArtModel {

    private static final int SIZE = 8;

    private final boolean[][] pixels = new boolean[SIZE][SIZE];

    private int cursorRow = 0;
    private int cursorCol = 0;

    public int getSize() {
        return SIZE;
    }

    public boolean isPixelOn(int row, int col) {
        return pixels[row][col];
    }

    public int getCursorRow() {
        return cursorRow;
    }

    public int getCursorCol() {
        return cursorCol;
    }

    public void moveCursorUp() {
        if (cursorRow > 0) {
            cursorRow--;
        }
    }

    public void moveCursorDown() {
        if (cursorRow < SIZE - 1) {
            cursorRow++;
        }
    }

    public void moveCursorLeft() {
        if (cursorCol > 0) {
            cursorCol--;
        }
    }

    public void moveCursorRight() {
        if (cursorCol < SIZE - 1) {
            cursorCol++;
        }
    }

    public void togglePixel() {
        pixels[cursorRow][cursorCol] = !pixels[cursorRow][cursorCol];
    }

    public String generateJavaCode() {
        StringBuilder code = new StringBuilder();

        code.append("int[][] pixelArt = {\n");

        for (int row = 0; row < SIZE; row++) {
            code.append("    {");

            for (int col = 0; col < SIZE; col++) {
                code.append(pixels[row][col] ? "1" : "0");

                if (col < SIZE - 1) {
                    code.append(", ");
                }
            }

            code.append("}");

            if (row < SIZE - 1) {
                code.append(",");
            }

            code.append("\n");
        }

        code.append("};");

        return code.toString();
    }
}