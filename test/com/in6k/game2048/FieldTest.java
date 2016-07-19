package com.in6k.game2048;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FieldTest {
    private Field field = new Field();

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void isFieldGeneratedRigth() throws Exception {
        field.generateNewField();
        int numberOfCell = 0;
        for (int i = 0; i < Field.FIELD_LENGTH; i++) {
            for (int k = 0; k < Field.FIELD_LENGTH; k++) {
                if (field.getField().get(i).get(k).getValue() == 2) {
                    numberOfCell++;
                }
            }
        }
        assertThat(numberOfCell, is(2));
    }
}
