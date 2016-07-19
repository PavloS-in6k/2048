package com.in6k.game2048;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FieldTest {
    private Field field;

    @Before
    public void setUp() throws Exception {
        field = new Field();
    }

    @Test
    public void isRandomValueAdded() throws Exception {
        int numberOfNonEmptyCells = getNumberOfNonEmptyCells();
        field.addRandomCell();
        assertThat(numberOfNonEmptyCells+1, is(getNumberOfNonEmptyCells()));
    }

    @Test
    public void isFieldGeneratedWithTwoNonEmptyCells() throws Exception {
        int numberOfNonEmptyCells = getNumberOfNonEmptyCells();
        assertThat(numberOfNonEmptyCells, is(2));
    }

    private int getNumberOfNonEmptyCells() {
        int numberOfCell = 0;
        for (int i = 0; i < Field.FIELD_LENGTH; i++) {
            for (int k = 0; k < Field.FIELD_LENGTH; k++) {
                if (isCellNotEmpty(i, k)) {
                    numberOfCell++;
                }
            }
        }
        return numberOfCell;
    }

    private boolean isCellNotEmpty(int i, int k) {
        return field.getField().get(i).get(k).getValue() != 0;
    }
}
