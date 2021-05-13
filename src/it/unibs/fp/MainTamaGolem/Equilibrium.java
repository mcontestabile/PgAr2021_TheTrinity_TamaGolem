package it.unibs.fp.MainTamaGolem;

import java.util.Random;

public class Equilibrium {
    private int maxPower;
    private int numRow;
    private int numCol;
    private int[][] matrix;
    public static final int IF_LOWER = -1;
    public static final int EACH_CASE = 0;
    public static final int IF_HIGHER = 1;

    public void generateEquilibrium(int maxPower, int numElements) {
        this.maxPower = maxPower;
        numRow = numCol = numElements;
        generateMatrix();
    }

    private void generateMatrix() {
        matrix = new int[numRow][numCol];
        int rowSum, value=0, min, max, remainingCols;

        for (int r = 0; r < (numRow-1); r++) {
            rowSum = 0;
            for (int c = 0; c < numCol; c++) {
                if (c == r) continue;
                if ((c + 1) <= (numCol / 2) && c > r) {
                    value = randomInteger(1, maxPower);
                } else if (c != (numCol - 1) && c > r) {
                    remainingCols = numCol - (c + 1);

                    min = Math.max(Math.min(remainingCols * (-maxPower) - rowSum, maxPower), -maxPower);
                    max = Math.min(Math.max(remainingCols * (maxPower) - rowSum, -maxPower), maxPower);

                    do {
                        value = randomInteger(min, max, (c == (numCol - 2)) ? new int[]{-rowSum, 0} : new int[]{0});
                    } while (min != max && (remainingCols * maxPower + rowSum + value) == 0);
                } else if (c == (numCol - 1)) {
                    //int e = 0;
                    while (rowSum == 0 || rowSum < -maxPower || rowSum > maxPower) {
                        //e++;
                        for (int col = 0; col < r; col++) {
                            swapCells(col, r, col, numCol - 1, (rowSum == 0 ? EACH_CASE : (rowSum > maxPower ? IF_LOWER : IF_HIGHER)));
                            rowSum = 0;
                            for (int i = 0; i < (numCol - 1); i++) rowSum += matrix[r][i];
                            if (rowSum >= -maxPower && rowSum <= maxPower && rowSum != 0) break;
                        }/*
                        if (e == 100000) {
                            System.out.println("ERRORE WHILE");
                            for (int ro = 0; ro < numRow; ro++) {
                                for (int co = 0; co < numCol; co++) {
                                    System.out.format("%3d\t", matrix[ro][co]);
                                }
                                System.out.println();
                            }
                            break;
                        }
                        */
                    }

                    value = -rowSum;
                }

                if (c > r) {
                    matrix[r][c] = value;
                    matrix[c][r] = -value;
                }

                rowSum += matrix[r][c];

                /*
                if (matrix[r][c] == 0 || matrix[r][c] < -maxPower || matrix[r][c] > maxPower) {
                    System.out.println("RIGENERO");
                    for (int ro = 0; ro < numRow; ro++) {
                        for (int co = 0; co < numCol; co++) {
                            System.out.format("%3d\t", matrix[ro][co]);
                        }
                        System.out.println();
                    }
                }
                 */
            }
        }
    }

    /**
     * Generates a pseudorandom integer in the range [min, max]
     *
     * @param min The starting value of the range (inclusive)
     * @param max The ending value of the range (inclusive)
     */
    private int randomInteger(int min, int max, int... exclude) {
        int random;
        boolean end;
        do {
            end = true;
            random = new Random().nextInt((Math.max(min, max)) - Math.min(min, max) + 1) + Math.min(min, max);
            for (int n : exclude)
                if (random == n) {
                    end = false;
                    break;
                }
        } while (!end);
        return random;
    }

    private void swapCells(int rOne, int cOne, int rTwo, int cTwo, final int CONDITION) {
        boolean swap = false;
        int firstValue = matrix[rOne][cOne];
        int secondValue = matrix[rTwo][cTwo];
        switch (CONDITION) {
            case IF_LOWER -> {
                if (firstValue < secondValue) swap = true;
            }
            case EACH_CASE -> {
                if (firstValue > -maxPower && secondValue < maxPower) {
                    matrix[rOne][cOne]--;
                    matrix[rTwo][cTwo]++;
                } else if (firstValue < maxPower && secondValue > -maxPower) {
                    matrix[rOne][cOne]++;
                    matrix[rTwo][cTwo]--;
                }

                matrix[cOne][rOne] = -matrix[rOne][cOne];
                matrix[cTwo][rTwo] = -matrix[rTwo][cTwo];
            }
            case IF_HIGHER -> {
                if (matrix[rOne][cOne] > matrix[rTwo][cTwo]) swap = true;
            }
        }
        if (swap) {
            int t = matrix[rOne][cOne];
            matrix[rOne][cOne] = matrix[rTwo][cTwo];
            matrix[rTwo][cTwo] = t;

            matrix[cOne][rOne] = -matrix[rOne][cOne];
            matrix[cTwo][rTwo] = -matrix[rTwo][cTwo];
        }
    }

    public int[][] getEquilibriumMatrix() {
        return matrix;
    }

    public int getNumRow() {
        return numRow;
    }

    public int getNumCol() {
        return numCol;
    }
}
