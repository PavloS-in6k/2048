package com.in6k.game2048;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    private Field field;

    public Controller(Field field) {
        this.field = field;
    }

    public void doSlide(Command command) {
        if (!isGameOver()) {
            switch (command) {
                case SLIDE_LEFT: {
                    reverseField(field.getField());
                    slideSide(field.getField());
                    reverseField(field.getField());
                    break;
                }
                case SLIDE_RIGTH: {
                    slideSide(field.getField());
                    break;
                }
                case SLIDE_UP: {
                    transpose(field.getField());
                    reverseField(field.getField());
                    slideSide(field.getField());
                    reverseField(field.getField());
                    transpose(field.getField());
                    break;
                }
                case SLIDE_DOWN: {
                    transpose(field.getField());
                    slideSide(field.getField());
                    transpose(field.getField());
                    break;
                }
            }
            field.addRandomCell();
        } else
            System.out.print("GAMEOVER");
    }

    public boolean isGameOver() {
        boolean isGameOver = false;
        List<List<Cell>> savedField = field.getField();
        for (int i = 0; i < savedField.size(); i++) {
            slideOneRow(savedField.get(i));
            if (!(savedField.get(i).equals(field.getField().get(i)))) {
                isGameOver = true;
            }
        }
        return isGameOver;
    }

    private void reverseField(List<List<Cell>> fieldMatrix) {
        for (List<Cell> cellRow : fieldMatrix) {
            Collections.reverse(cellRow);
        }
    }

    protected void slideSide(List<List<Cell>> fieldMatrix) {
        for (List<Cell> cellRow : fieldMatrix) {
            slideOneRow(cellRow);
        }
    }

    protected void slideOneRow(List<Cell> row) {
        moveToBound(row);
        for (int i = row.size() - 1; i > 0; i--) {
            if ((row.get(i).getValue() == row.get(i - 1).getValue()) && (row.get(i).getValue() != 0)) {
                row.get(i - 1).increment();
                row.set(i, new Cell());
            }
        }
        moveToBound(row);
    }

    private void moveToBound(List<Cell> row) {
        for (int i = row.size() - 1; i > 0; i--) {
            if (row.get(i).getValue() == 0) {
                for (int k = i - 1; k >= 0; k--) {
                    if (row.get(k).getValue() != 0) {
                        Collections.swap(row, i, k);
                        break;
                    }
                }
            }
        }
    }

    public static void transpose(List<List<Cell>> matrixIn) {
        List<List<Cell>> matrixOut = new ArrayList<>();
        if (!matrixIn.isEmpty()) {
            int noOfElementsInList = matrixIn.get(0).size();
            for (int i = 0; i < noOfElementsInList; i++) {
                List<Cell> col = new ArrayList<>();
                for (List<Cell> row : matrixIn) {
                    col.add(row.get(i));
                }
                matrixOut.add(col);
            }
        }
        Collections.copy(matrixIn, matrixOut);
    }

    protected Field getField() {
        return field;
    }
}