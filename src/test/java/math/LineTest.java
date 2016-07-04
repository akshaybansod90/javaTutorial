package math;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Akshay on 6/20/2016.
 */
public class LineTest {

    private MaxPointOnLine.Point2D[] point2D = new MaxPointOnLine.Point2D[6];

    @Before
    public void setUp() {
        point2D[0] = new MaxPointOnLine.Point2D(1, 1);
        point2D[1] = new MaxPointOnLine.Point2D(1, 2);
        point2D[2] = new MaxPointOnLine.Point2D(3, 3);
        point2D[3] = new MaxPointOnLine.Point2D(3, 4);
        point2D[4] = new MaxPointOnLine.Point2D(1, 4);
        point2D[5] = new MaxPointOnLine.Point2D(2, 4);
    }

    @Test
    public void equalsTest() throws Exception {
        MaxPointOnLine.Line line = new MaxPointOnLine.Line(point2D[1], point2D[5]);
        MaxPointOnLine.Line line1 = new MaxPointOnLine.Line(2.0,-4.0,0.0);
        assertTrue(line.equals(line1));
    }

    @Test
    public void hashCodeTest() throws Exception {

        MaxPointOnLine.Line line = new MaxPointOnLine.Line(point2D[2], point2D[3]);
        MaxPointOnLine.Line line1 = new MaxPointOnLine.Line(0.0, -1.0, 3);
        assertTrue(line.hashCode() == line1.hashCode());
    }

}