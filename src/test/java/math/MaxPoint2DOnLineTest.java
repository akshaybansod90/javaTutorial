package math;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by Akshay on 6/20/2016.
 */
public class MaxPoint2DOnLineTest {



    @Test
    public void maxPoints() throws Exception {
        MaxPointOnLine.Point2D[] point2D = new MaxPointOnLine.Point2D[3];
        point2D[0] = new MaxPointOnLine.Point2D(0,0);
        point2D[1] = new MaxPointOnLine.Point2D(1,1);
        point2D[2] = new MaxPointOnLine.Point2D(0,0);
       /* point2D[3] = new MaxPointOnLine.Point2D(4,4);
        point2D[4] = new MaxPointOnLine.Point2D(1,1);
        point2D[5] = new MaxPointOnLine.Point2D(1,0);*/
        assertEquals(MaxPointOnLine.maxPoints(point2D),3);
    }

    @Test
    public void maxPoints1() throws Exception {
        MaxPointOnLine.Point2D[] point2D = new MaxPointOnLine.Point2D[2];
        point2D[0] = new MaxPointOnLine.Point2D(0,0);
        point2D[1] = new MaxPointOnLine.Point2D(0,0);
      //  point2D[2] = new MaxPointOnLine.Point2D(0,0);
        assertEquals(MaxPointOnLine.maxPoints(point2D),2);
    }

    @Test
    public void maxPoints2() throws Exception{
        List<MaxPointOnLine.Point2D> point2DList = new ArrayList<>();
        Scanner input = new Scanner(new File("src/test/resources/MaxPoint2DOnLineInput.txt"));
        while (input.hasNext()) {
            point2DList.add(new MaxPointOnLine.Point2D(input.nextInt(), input.nextInt()));
        }
        MaxPointOnLine.Point2D[] point2Ds = new MaxPointOnLine.Point2D[point2DList.size()];
        for (int i = 0; i < point2Ds.length; i++) {
            point2Ds[i] = point2DList.get(i);
        }
        System.out.println(MaxPointOnLine.maxPoints(point2Ds));

    }

}