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
        switch (command) {
            case SLIDE_LEFT: {
                break;
            }
            case SLIDE_RIGTH: {
                break;
            }
            case SLIDE_UP: {
                break;
            }
            case SLIDE_DOWN: {
                break;
            }
        }
        field.addRandomCell();
    }

    protected void slide(List<Cell> row) {
        moveToBound(row);
        for (int i = row.size() - 1; i > 0; i--) {
            if ((row.get(i).getValue() == row.get(i - 1).getValue()) && (row.get(i).getValue() != 0)) {
                row.set(i - 1, row.get(i - 1).increment());
                row.set(i, new Cell());
            }
        }
        moveToBound(row);
    }

    private void moveToBound(List<Cell> row) {
        for (int i = row.size() - 1; i > 0; i--) {
            if (row.get(i).getValue() == 0) {
                for (int k = i-1; k >= 0; k--) {
                    if (row.get(k).getValue() != 0) {
                        Collections.swap(row, i, k);
                        break;
                    }
                }
            }
        }
    }

    public static List<List<Cell>> transpose(ArrayList<ArrayList<Cell>> matrixIn) {
        List<List<Cell>> matrixOut = new ArrayList<List<Cell>>();
        if (!matrixIn.isEmpty()) {
            int noOfElementsInList = matrixIn.get(0).size();
            for (int i = 0; i < noOfElementsInList; i++) {
                List<Cell> col = new ArrayList<Cell>();
                for (List<Cell> row : matrixIn) {
                    col.add(row.get(i));
                }
                matrixOut.add(col);
            }
        }
        return matrixOut;
    }

    protected Field getField() {
        return field;
    }
}