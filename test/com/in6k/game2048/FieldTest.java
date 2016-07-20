package com.in6k.game2048;

import com.in6k.game2048.RandomGenerator.RandomGeneratorForTests;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;

public class FieldTest {
    private Field field;

    @Before
    public void setUp() throws Exception {
        List<List<Cell>> fieldList = new ArrayList<>();
        fieldList.add(Arrays.asList(new Cell(), new Cell(), new Cell(), new Cell()));
        fieldList.add(Arrays.asList(new Cell(), new Cell(), new Cell(), new Cell()));
        fieldList.add(Arrays.asList(new Cell(), new Cell(), new Cell(), new Cell()));
        fieldList.add(Arrays.asList(new Cell(), new Cell(), new Cell(), new Cell()));
        field = new Field(fieldList);
    }

    @Test
    public void isEmptyCellsSelectorWorks() throws Exception {
        field.addRandomCell();
        field.addRandomCell();
        field.addRandomCell();
        field.addRandomCell();
        field.addRandomCell();

        assertThat(field.getEmptyCells().size(), is(11));
    }

    @Test
    public void isRandomGenerated() throws Exception {
        field.setRandom(new RandomGeneratorForTests(0));
        field.addRandomCell();

        assertThat(field.getCellsValuesAsList(), contains(
                2, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        ));
    }

    @Test
    public void isFieldGeneratedWithTwoNonEmptyCells() throws Exception {
        field.setRandom(new RandomGeneratorForTests(0));
        field.addRandomCell();
        field.addRandomCell();

        assertThat(field.getCellsValuesAsList(), contains(
                2, 2, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        ));
    }


    @Test
    public void isParserFromLinearArrayWorking() throws Exception {
        field.setFieldFromLinearList(
                Arrays.asList(
                        0, 2, 0, 2,
                        4, 0, 2, 2,
                        16, 0, 2, 8,
                        8, 4, 0, 0
                )
        );

        assertThat(field.getCellsValuesAsList(), contains(
                0, 2, 0, 2,
                4, 0, 2, 2,
                16, 0, 2, 8,
                8, 4, 0, 0
        ));
    }
}
