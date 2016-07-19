package com.in6k.game2048;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ControllerTest {
    private Controller controller = new Controller(new Field());
    private Field field = controller.getField();


    @Before
    public void setUp() throws Exception {
        controller = new Controller(new Field());
        field = controller.getField();
    }

    @Test
    public void isSlideWorksWithBoundValues() throws Exception {
        List<Cell> row = Arrays.asList(new Cell(), new Cell(), new Cell(2), new Cell(2));
        controller.slide(row);
        assertThat(row.get(Field.FIELD_LENGTH - 1).getValue(), is(4));
    }

}
