package com.in6k.game2048;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ControllerTest {
    private Controller controller = new Controller(new Field());
    private Field field = controller.getField();

    @Before
    public void setUp() throws Exception {
        List<List<Cell>> fieldList = new ArrayList<>();
        fieldList.add(Arrays.asList(new Cell(), new Cell(), new Cell(), new Cell()));
        fieldList.add(Arrays.asList(new Cell(), new Cell(), new Cell(), new Cell()));
        fieldList.add(Arrays.asList(new Cell(), new Cell(), new Cell(), new Cell()));
        fieldList.add(Arrays.asList(new Cell(), new Cell(), new Cell(), new Cell()));
        controller = new Controller(new Field(fieldList));
        field = controller.getField();
    }

    @Test
    public void isSlideRowWorksWithBoundValues() throws Exception {
        field.getField().get(0).set(2, new Cell(2));
        field.getField().get(0).set(3, new Cell(2));
        controller.doSlide(Command.SLIDE_RIGTH);
        assertThat(controller.getField().getCellsValuesAsList(), is(Arrays.asList(
                0, 0, 0, 4,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0

        )));
    }

    @Test
    public void name() throws Exception {


    }
}
