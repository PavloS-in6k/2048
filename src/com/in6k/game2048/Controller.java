package com.in6k.game2048;

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

    protected List<Cell> slide(List<Cell> row) {
        for (int i = 1; i < row.size(); i++) {
            if ((row.get(i).getValue() == row.get(i - 1).getValue()) && (row.get(i).getValue() != 0)) {
                row.set(i - 1, row.get(i - 1).increment());
                row.set(i, new Cell());
            }
        }
        return row;
    }

}
