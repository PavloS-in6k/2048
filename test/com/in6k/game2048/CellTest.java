package com.in6k.game2048;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CellTest {
    private Cell cell;

    @Before
    public void setUp() throws Exception {
        cell = new Cell();
    }

    @Test
    public void isFirstValueIsZero() throws Exception {
        assertThat(cell.getValue(), is(0));
    }

    @Test
    public void isFirstCallOfIncrementWorking() throws Exception {
        assertThat(cell.getValue(), is(0));
        cell.increment();
        assertThat(cell.getValue(), is(2));
    }
}
