package com.in6k.game2048;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

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
        assertThat(controller.getField().getCellsValuesAsList(), contains(
                0, 0, 0, 4,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0

        ));
    }

    @Test
    public void isRow2448SlidedCorrect() throws Exception {
        field.getField().get(0).set(0, new Cell(2));
        field.getField().get(0).set(1, new Cell(4));
        field.getField().get(0).set(2, new Cell(4));
        field.getField().get(0).set(3, new Cell(8));

        controller.doSlide(Command.SLIDE_RIGTH);

        assertThat(controller.getField().getCellsValuesAsList(), contains(
                0, 2, 8, 8,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0

        ));
    }

    @Test
    public void isRow0424SlidedCorrect() throws Exception {
        field.getField().get(0).set(0, new Cell(0));
        field.getField().get(0).set(1, new Cell(4));
        field.getField().get(0).set(2, new Cell(2));
        field.getField().get(0).set(3, new Cell(4));

        controller.doSlide(Command.SLIDE_RIGTH);

        assertThat(controller.getField().getCellsValuesAsList(), contains(
                0, 4, 2, 4,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        ));
    }

    @Test
    public void isColumn2024SlidedCorrect() throws Exception {
        field.getField().get(0).set(0, new Cell(2));
        field.getField().get(1).set(0, new Cell(0));
        field.getField().get(2).set(0, new Cell(2));
        field.getField().get(3).set(0, new Cell(4));

        controller.doSlide(Command.SLIDE_DOWN);

        assertThat(controller.getField().getCellsValuesAsList(), contains(
                0, 0, 0, 0,
                0, 0, 0, 0,
                4, 0, 0, 0,
                4, 0, 0, 0
        ));
    }

    @Test
    public void isScoreAddedRigth() throws Exception {
        field.getField().get(0).set(2, new Cell(2));
        field.getField().get(0).set(3, new Cell(2));
        controller.doSlide(Command.SLIDE_RIGTH);
        assertThat(controller.getScore(), equalTo(4));
    }

    @Test
    public void isScoreWithTwoSlidesMatchedRigth() throws Exception {
        field.getField().get(0).set(0, new Cell(2));
        field.getField().get(0).set(1, new Cell(2));
        field.getField().get(0).set(2, new Cell(2));
        field.getField().get(0).set(3, new Cell(2));
        controller.doSlide(Command.SLIDE_RIGTH);
        assertThat(controller.getScore(), equalTo(16));
        controller.doSlide(Command.SLIDE_RIGTH);
        assertThat(controller.getScore(), equalTo(24));
    }

    @Test
    public void isLeftSlideWorking() throws Exception {
        setEtalonField();

        controller.doSlide(Command.SLIDE_LEFT);

        assertThat(controller.getField().getCellsValuesAsList(), contains(
                4, 0, 0, 0,
                2, 0, 0, 0,
                4, 2, 0, 0,
                4, 0, 0, 0
        ));
    }



    private void setEtalonField() {
        field.setFieldFromLinearList(
                Arrays.asList(
                        0, 0, 2, 2,
                        0, 2, 0, 0,
                        0, 4, 2, 0,
                        2, 0, 0, 2
                )
        );
    }
}
